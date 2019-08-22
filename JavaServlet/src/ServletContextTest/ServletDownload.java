package ServletContextTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servletDownload")
public class ServletDownload extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取请求参数
        String filename = request.getParameter("filename");
        //使用字节输入流加载文件进内存
        //找到服务器路径
        ServletContext context=this.getServletContext();
        String realPath = context.getRealPath("/img/"+filename);
        //使用字节流
        FileInputStream fis=new FileInputStream(realPath);
        //设置response响应头
        String mimeType = context.getMimeType(filename);//获取文件类型
        response.setHeader("content-type",mimeType);
        //设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);
        //字节流输出
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1)
        {
            outputStream.write(bytes,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
