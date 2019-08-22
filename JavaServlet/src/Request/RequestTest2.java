package Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*  1.获取请求参数通用方式

      1. String getParameter(String name) :根据参数名称获取参数值  username=zs&password=123

      2. String[] getparameterValues(String name) :根据参数名称获取参数值的数组  hobby=xx&hobby=game
      3. Enumeration<String> getPar ameterNames( ) :获取所有请求的参数名称
      4. Map<String, string[]> getParameterMap(): 获取所有参数的map集合
        post乱码时，在请求参数获取前加上request.setCharacterEncoding("utf-8");

*
* */
@WebServlet("/RequestTest2")
public class RequestTest2 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RequestTest1");
        requestDispatcher.forward(request,response);
        * */
        request.getRequestDispatcher("/RequestTest1").forward(request,response);//请求转发。
        System.out.println("req..........");
        //特点    1.浏览器地址栏不会变化
        //        2.只能转发到当前服务器内部资源中
        //        3.转发是一次请求。

//      共享数据request域，作业范围一次请求转发的多个资源中。
//        request.setAttribute(String s,Object obj);存储数据/设置共享数据
//        request.getAttribute(String name);通过键获取值
//        request.removeAttribute(String name);通过键移除值
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/RequestTest1").forward(request,response);//请求转发。
        System.out.println("Request2....");
    }
}
