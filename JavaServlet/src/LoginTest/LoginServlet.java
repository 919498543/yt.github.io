package LoginTest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet2")
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username1 = request.getParameter("username1");
        String password1 = request.getParameter("password1");
        //封装user对象
        User loginUser=new User();
        loginUser.setNumber(username1);
        loginUser.setPassword(password1);
        //调用DoUser的login方法
        UserDao dao=new UserDao();
        User user = dao.login(loginUser);
        //判断user
        if (user == null)
        {
            //登录失败，转发到另一网页
            request.getRequestDispatcher("/failServlet").forward(request, response);
        }
        else
        {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }
}

