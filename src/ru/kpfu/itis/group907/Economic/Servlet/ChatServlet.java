package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.ChatDao;
import kpfu.itis.group907.Economic.Dto.ChatDto;
import kpfu.itis.group907.Economic.Dto.DiagramDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login_2 = req.getParameter("User") + "";
        ChatDao chatDao = new ChatDao(req.getSession().getAttribute("login") + "", login_2 + "");

        List<ChatDto> chatDtoList = chatDao.getAllMessage();
        req.setAttribute("chatDtoList", chatDtoList);
        req.getRequestDispatcher("Chat.ftl").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login_2 = req.getParameter("login") + "";
        String message = req.getParameter("message") + "";
        System.out.println(login_2 + " " + message);
        ChatDao chatDao = new ChatDao(req.getSession().getAttribute("login") + "", login_2);
        chatDao.createMessage(message);
    }
}
