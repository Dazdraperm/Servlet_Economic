package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.DefaultUserDaoImpl;
import kpfu.itis.group907.Economic.Models.DefaultUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet( urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = "Hi";

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(s);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DefaultUserDaoImpl defaultUserDao = new DefaultUserDaoImpl();

        String s = req.getParameter("inputUser") + "";
        ArrayList<String> defaultUser = defaultUserDao.getAll(s);
        String result = "";

        for (int i = 0; i < defaultUser.size(); i++) {
            if (i < defaultUser.size() - 1) {
                result += defaultUser.get(i) + " ";
            }
            else {
                result += defaultUser.get(i) + "";
            }
        }

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(result);
    }
}
