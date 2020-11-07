package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Helpers.PasswordHelper;
import kpfu.itis.group907.Economic.Models.DefaultUser;
import kpfu.itis.group907.Economic.Service.DefaultUserService;
import kpfu.itis.group907.Economic.Service.Impl.DefaultUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("Login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("email");
        String password = req.getParameter("password");
        password = PasswordHelper.encrypt(login, password);
        DefaultUserService userService = new DefaultUserServiceImpl();

        try {
            DefaultUser defaultUser = userService.get(login,password);
            if (defaultUser != null){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("name", defaultUser.getFIRST_NAME());
                httpSession.setAttribute("login", defaultUser.getLogin());
                httpSession.setMaxInactiveInterval(24 * 60 * 60);


                Cookie userCookie = new Cookie("login", defaultUser.getLogin());
                userCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(userCookie);

                resp.sendRedirect("Index.ftl");

            }
            else {
                resp.sendRedirect("Login.ftl");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
