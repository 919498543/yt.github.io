package CookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCookieTest")
public class ServletCookieTest extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie c : cookies)
            {
                String name=c.getName();
                String value=c.getValue();
                System.out.println("name:"+name+"   value"+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
