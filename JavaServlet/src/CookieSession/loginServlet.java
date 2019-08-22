package CookieSession;

import LoginTest.User;
import LoginTest.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //获取生成的验证码
        HttpSession session = request.getSession();
        String codeSession = (String) session.getAttribute("checkCodeSession");
        //删除session中存储的验证码
        session.removeAttribute("checkCodeSession");
        if(codeSession!=null && codeSession.equalsIgnoreCase(checkCode))
        {
            //验证码正确
            //封装user对象
            User loginUser=new User();
            loginUser.setNumber(username);
            loginUser.setPassword(password);
            //调用DoUser的login方法
            UserDao dao=new UserDao();
            User user = dao.login(loginUser);
            //判断user
            if (user == null)
            {
                //登录失败，转发到另一网页
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            else
            {
                List<User> users = dao.findAll();
                //重定向到success.jsp页面
                response.sendRedirect(request.getContextPath()+"/servletFindPage");
                session.setAttribute("user",user.getName());
                session.setAttribute("users",users);

            }
        }
        else
            {
                //验证码不一致，提示错误信息到登录页面
                request.setAttribute("check_error","验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

    }
}

