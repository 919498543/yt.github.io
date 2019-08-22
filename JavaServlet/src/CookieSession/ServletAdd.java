package CookieSession;

import LoginTest.User;
import LoginTest.UserDao;
import javafx.scene.control.Alert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/servletAdd")
public class ServletAdd extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        //获取请求参数

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        if(username==null||username.length()==0)
        {
            request.setAttribute("add_error","用户名不能为空");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }
        else
            {
                int age2 = Integer.parseInt(age);
                //封装user对象
                User user = new User();
                user.setNumber(username);
                user.setPassword(password);
                user.setName(name);
                user.setAge(age2);
                //调用DoUser的login方法
                UserDao dao = new UserDao();
                dao.insert(user);
                response.sendRedirect(request.getContextPath() + "/servletList");
            }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
