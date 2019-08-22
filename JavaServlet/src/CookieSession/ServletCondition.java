package CookieSession;

import LoginTest.User;
import LoginTest.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/servletCondition")
public class ServletCondition extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage==null||"".equals(currentPage))
        {
            currentPage="1";
        }
        if(rows==null||"".equals(rows))
        {
            rows="5";
        }
        Map<String, String[]> map = request.getParameterMap();
        Page<User> page=this.findPage(currentPage,rows,map);
        request.setAttribute("map",map);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
    public Page<User> findPage(String currentPage, String rows,Map<String, String[]> map)
    {

        Page<User> page=new Page<User>();
        UserDao dao=new UserDao();
        int c = Integer.parseInt(currentPage);
        int r = Integer.parseInt(rows);
        if(c<=0)
        {
            c=1;
        }
        int totalCount=dao.findTotalCount(map);
        int totalPage=(totalCount % r)==0? (totalCount/r):(totalCount/r)+1;
        if(c>=totalPage)
        {
            c=totalPage;
        }
        page.setCurrentPage(c);
        page.setRows(r);
        page.setTotalCount(totalCount);
        int start=(c-1)*r;
        List<User> list= dao.findPage(start,r,map);
        page.setList(list);
        page.setTotalPage(totalPage);
        return page;
    }
}
