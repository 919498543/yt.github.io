package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 响应头
*   设置响应头：setHeader(String name,String value)
*   Content-Type:服务器告诉客户端响应体数据格式以及编码格式
*   Content-disposition:服务器告诉客户端以什么格式打开响应体数据
*       in-line:默认值，在当前页面打开
*       attachment;filename=xxx:以附件的形式打开，文件下载
* 响应行
*   格式：HTTP/1.1   200 ok(200是状态码，
*   设置状态码：setStatus(int sc)
* 响应空行
* 响应体
*   设置响应体步骤
*       1.获取输出流
*           字符输出流：PrintWriter getWriter()
*           字节输出流：ServletOutputStream getOutputStream()
*       2.使用输出流，将数据输出到客户端浏览器。
* 案例
*   1.重定向 状态码302和路径响应头location   //虚拟路径建议动态获取，String getContextPath()
*   2.字符字节输出
*   3.验证码
* */
@WebServlet("/responseTest")
public class ResponseTest extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        System.out.println("Test1......");
        //重定向  方式一
        //设置状态码
        response.setStatus(302);
        //设置响应头
        response.setHeader("location","/responseTest2");
        //方式二
//        response.sendRedirect("responseTest2");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException
    {
        doPost(request,response);
    }

}
