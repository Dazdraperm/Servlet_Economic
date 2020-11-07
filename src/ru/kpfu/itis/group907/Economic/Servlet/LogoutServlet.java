package kpfu.itis.group907.Economic.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {

                }
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        HttpSession httpSession = req.getSession(false);

        if (httpSession != null) {
            httpSession.invalidate();
        }

        resp.sendRedirect("/login");
    }
}
