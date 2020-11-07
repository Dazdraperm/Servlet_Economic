package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.DefaultUserDaoImpl;
import kpfu.itis.group907.Economic.Dao.Impl.DiagramDao;
import kpfu.itis.group907.Economic.Dto.DiagramDto;
import kpfu.itis.group907.Economic.Models.DefaultUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String account = req.getParameter("login");
        String login = (String) httpSession.getAttribute("login");
        DefaultUserDaoImpl userDao = new DefaultUserDaoImpl();
        List<DefaultUser> listUser = new ArrayList<>();
        System.out.println(account);
        if (login.equals(account)) {
            listUser.add(userDao.baseGet(login));


            DiagramDao diagramDao = new DiagramDao(login);
            List<DiagramDto> listCategory = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : diagramDao.getAll().entrySet()) {
                listCategory.add(new DiagramDto(entry.getKey(), entry.getValue() + ""));

            }

            req.setAttribute("listUser", listUser);
            req.setAttribute("listCategory", listCategory);
            req.getRequestDispatcher("Profile.ftl").forward(req, resp);
        }
        else {
            listUser.add(userDao.baseGet(account));
            DiagramDao diagramDao = new DiagramDao(account);
            List<DiagramDto> listCategory = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : diagramDao.getAll().entrySet()) {
                listCategory.add(new DiagramDto(entry.getKey(), entry.getValue() + ""));
            }

            req.setAttribute("listUser", listUser);
            req.setAttribute("listCategory", listCategory);
            req.getRequestDispatcher("ForeignProfile.ftl").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        HttpSession httpSession = req.getSession();

        DefaultUserDaoImpl defaultUserDao = new DefaultUserDaoImpl();
        String name =  req.getParameter("name_user");
        String last_name =  req.getParameter("last_name");
        String new_login =  req.getParameter("login");
        String email =  req.getParameter("email");

        if(defaultUserDao.changeUser(name, last_name, new_login, email, login)){
            if(name.length() > 10){
                name = name.substring(1, 10);
            }
            httpSession.setAttribute("name", name);
            httpSession.setAttribute("login", new_login);
            resp.sendRedirect("/profile?login=" + new_login);
        }
        else {
            resp.sendRedirect("/");
        }

    }
}
