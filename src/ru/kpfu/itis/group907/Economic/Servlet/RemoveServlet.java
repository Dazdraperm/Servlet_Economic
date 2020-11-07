package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.DiagramDao;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        DiagramDao diagramDao = new DiagramDao(req.getSession().getAttribute("login") + "");

        String s = req.getParameter("name_delete_category") + "";
        System.out.println(s);
        diagramDao.remove(s);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
    }
}
