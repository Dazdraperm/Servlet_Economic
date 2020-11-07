package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.ChatDao;
import kpfu.itis.group907.Economic.Dto.ChatDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/chatMain")
public class ChatRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getSession().getAttribute("login") + "";
        ChatDao chatDao = new ChatDao(login);
        List<ChatDto> chatDtoList  = chatDao.getAllUsersWithMassage();

        req.setAttribute("chatDtoList",chatDtoList);
        req.getRequestDispatcher("ChatMain.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login_2 = req.getParameter("login") + "";
        ChatDao chatDao = new ChatDao(req.getSession().getAttribute("login") + "", login_2 + "");

        List<ChatDto> chatDtoList = chatDao.getAllMessage();

        String result = "";

        for (int i = 0; i < chatDtoList.size(); i++) {
            ChatDto message = chatDtoList.get(i);
            if(i + 1 == chatDtoList.size()) result += message.getLogin_user() + "3321" + message.getText() ;
            else result += message.getLogin_user() + "3321" + message.getText() + "33211";
        }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(result);
    }
}
