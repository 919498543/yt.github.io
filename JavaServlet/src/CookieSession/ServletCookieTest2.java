package CookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
* cookie会话是将共享数据保存到浏览器客户端 一次会话多次请求间
* session会话是将共享数据保存到服务器端 一次会话多次请求间的数据共享
* */
@WebServlet("/ServletCookieTest2")
public class ServletCookieTest2 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取所有cookie
        Cookie[] cookies =request.getCookies();
        //遍历cookies数组
        boolean flag=false;
        if(cookies!=null&&cookies.length>0)
        {
            response.setContentType("text/html;charset=utf-8");
            for (Cookie cookie:cookies)
            {
                String name=cookie.getName();
                if("lastTime".equals(name))
                {
                    flag=true;
                    //有cookie，非第一次访问
                    //设置cookie的值
                    Date date =new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    //获取cookie的value，（时间
                    cookie.setMaxAge(60*60*24*7);
                    String value=cookie.getValue();
                    value= URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为"+value+"</h1>");
                    //设置本次访问时的时间
                    cookie.setValue(str_date);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(cookies==null||cookies.length==0||flag==false)
        {
            //第一次访问
            //设置获取时间
            Date date =new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie=new Cookie("lastTime",str_date);
            cookie.setMaxAge(60*60*24*7);
            //设置value=访问时间
            cookie.setValue(str_date);
            str_date= URLDecoder.decode(str_date,"utf-8");
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎您首次登录</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
