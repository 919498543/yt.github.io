package ServletContextTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 代表整个web应用，可以和程序的容器（服务器）来通信
*   功能：
*       1.获取MIME类型 ；在互联网通信过程中定义的一种文件数据类型
*           格式   大类型/小类型   text/html   image/jpeg
*           获取   String getMimeType(string file)
*       2.域对象，共享数据
*       3.获取文件的真实（服务器）路径
*           context.getRealPath();
* */
@WebServlet(name = "ServletContextTest1")
public class ServletContextTest1 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //通过request对象获取
        ServletContext context1 =request.getServletContext();
        //通过HttpServlet获取
        ServletContext context2 =this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
