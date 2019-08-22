package LoginTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        //获取共享域中的user对象
        User user = (User) request.getAttribute("user");
        if (user != null)
        {
            //设置编码
            response.setContentType("text/html;charset=utf-8");
            //输出
            response.getWriter().write("登录成功! " + user.getName() + ",欢迎您");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
