package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 获取请求行数据
*   GET /day14/demo1 ?name=zhangsan HTTP/1.1
*   *方法:
*   1.获取请求方式: GET
        String getMethod( )
    2. (*)获取虚拟目录: /day14
        String getContextPath()
    3.获取Servlet路径: /demo1
        string getServletPath()
    4.获取get方式请求参数: name=zhangsan
*       String getQuerystring()
*   5. (*)获取请求URI : /day14/ demo1
*       String getRequestURI():     /day14/ demo1:
*       StringBuffer getRequestURL():   http://localhost/day14/ demo1
*   6.获取协议及版本: HTTP/1.1
*       String getProtocol()
*   7.获取客户机的IP地址:
*       string getRemoteAddr()
*
*
* */

@WebServlet("/RequestTest1")
public class RequestTest1 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Request1....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String method = request.getMethod();
        System.out.println(method);
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String queryString = request.getQueryString();
        System.out.println(queryString);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        String protocol = request.getProtocol();
        System.out.println(protocol);
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

    }
}
