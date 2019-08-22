package CookieSession;

import LoginTest.User;
import LoginTest.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletUpdate")
public class ServletUpdate extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int age2 = Integer.parseInt(age);
        User user=new User();
        user.setNumber(username);
        user.setAge(age2);
        user.setName(name);
        user.setPassword(password);
        UserDao dao=new UserDao();
        dao.update(user);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/servletList").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
