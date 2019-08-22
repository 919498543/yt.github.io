package CookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 创建cookie对象
*cookie在tomcat8之后可以存中文
* 生命周期，setMaxAge(int seconds);0删除，正数保存多少秒，时间到后，自动删除cookie文件，负数默认值
* 获取范围：（共享问题）
*       setPath(String path)设置cookie的获取范围，默认情况下是当前的虚拟目录
*       如果要共享，可以设置为"/"为当前服务器下所有项目共享
*
*       setDomain(String path):如果设置一级域名相同，多个服务器之间的cookie可以共享
*       例如setDomain(".baidu.com")
*
* */
@WebServlet("/servletCookie")
public class ServletCookie extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie cookie=new Cookie("msg","hello");
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
