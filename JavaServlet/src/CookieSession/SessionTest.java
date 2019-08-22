package CookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
* session是依赖于cookie的。当服务器不关闭，客户端关闭后再获取session，获取到的session是不同的值
*       如果要使其相同，可以设置Cookie c=new Cookie("键JSESSIONID"，"值(session.getID())")
*       response.addCookie(c);
*       默认session存活时间30分钟，自毁session方法invalidate();
*
* session的特点
      1. session用于存储一次会话的多次请求的数据，存在服务器端
      2. session可以存 储任意类型,任意大小的数据
* session与Cookie的区别:
      1. session存 储数据在服务器端，Cookie在客户端
      2. session没有数据大小限制，Cookie有
      3. session数据安全，Cookie相对于不安全
*
* */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取session
        HttpSession session = request.getSession();
        //设置数据
        session.setAttribute("msg","hello session");
        //获取数据
        session.getAttribute("msg");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
