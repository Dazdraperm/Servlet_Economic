package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.DefaultUserDaoImpl;
import kpfu.itis.group907.Economic.Dao.Impl.DiagramDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/search")
public class SearchOneCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiagramDao diagramDao = new DiagramDao(req.getSession().getAttribute("login") + "");

        String s = req.getParameter("inputUser") + "";
        HashMap<String, Integer> category = diagramDao.getOne(s);
        String result = "";
        for (Map.Entry<String, Integer> entry: category.entrySet()) {
            result += entry.getKey() + " " + entry.getValue();
        }




        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        System.out.println(result);
        resp.getWriter().write(result);
    }
}
