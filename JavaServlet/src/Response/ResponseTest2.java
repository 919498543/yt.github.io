package Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/responseTest2")
public class ResponseTest2 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Test2............");
        //获取流对象前，设置流的默认编码ISO-8859-1为utf-8
        response.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器使用的编码
        response.setHeader("context-Type","text/html;charset=utf-8");
        //编码方式二：
//        response.setContentType("text/html;charset=utf-8");
        //获取字符的输出流
        PrintWriter pw=response.getWriter();
        pw.write("hello->你好");
        //获取字节输出流
        ServletOutputStream sos=response.getOutputStream();
        sos.write("你好".getBytes());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }

}
