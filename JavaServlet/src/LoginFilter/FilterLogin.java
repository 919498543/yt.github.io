package LoginFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class FilterLogin implements Filter
{
    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest request=(HttpServletRequest) req;
        String uri = request.getRequestURI();
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js")||uri.contains("/fonts")||uri.contains("/checkedServlet")||uri.contains("/xuan.html")||uri.contains("/AJAX-js.html")||uri.contains("/servletAjax"))
        {
            chain.doFilter(request, resp);
        }
        else
            {
                Object user =request.getSession().getAttribute("user");
                if(user!=null)
                {
                    chain.doFilter(req,resp);
                }
                else
                    {

                        request.setAttribute("login_msg","请先登录");
                        request.getRequestDispatcher("/login.jsp").forward(request,resp);
                    }
            }
    }

    public void init(FilterConfig config) throws ServletException
    {

    }

}
