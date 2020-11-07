package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Dao.Impl.DiagramDao;
import kpfu.itis.group907.Economic.Dto.DiagramDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "diagramServlet", urlPatterns = "/diagram")
public class DiagramServlet extends HttpServlet {
    private String method = "";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String login = (String) req.getSession().getAttribute("login");
        DiagramDao diagramDao = new DiagramDao(login);
        List<DiagramDto> listCategory = new ArrayList<>();





        for (Map.Entry<String, Integer> entry : diagramDao.getAll().entrySet()) {
            listCategory.add(new DiagramDto(entry.getKey(), entry.getValue() + ""));

        }
        if (httpSession.getAttribute("check_category") == null || method.equals("get")) {
            httpSession.setAttribute("check_category", false);


        }

        this.method = "get";
        req.setAttribute("listCategory", listCategory);
        req.getRequestDispatcher("Diagram.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        method = "post";
        String nameCategory = req.getParameter("name_category");
        Integer countCategory = Integer.parseInt(req.getParameter("count_category"));
        String login1 = (String) req.getSession().getAttribute("login");
        DiagramDao diagramDao = new DiagramDao(login1);

        HttpSession httpSession = req.getSession();


        if (checkNameCategory(nameCategory)) {

            if (diagramDao.save(nameCategory, countCategory)) {
                httpSession.setAttribute("check_category", false);

            } else {
                httpSession.setAttribute("check_category", true);
            }
            resp.sendRedirect("/diagram");

        } else {

        }
    }


    private boolean checkNameCategory(String nameCategory) {//

        Pattern pattern = nameCategoryPatternCompile();
        Matcher matcherNameCategory = pattern.matcher(nameCategory);

        return matcherNameCategory.matches();

    }

    private static Pattern nameCategoryPatternCompile() {//Не менее 8 символов Содержит хотя бы одну цифру
        // Содержит хотя бы один нижний альфа char и один верхний альфа char
        // Содержит хотя бы один char в наборе специальных символов (@#%$^ и т.д.)
        // Не содержит пробелов, вкладок и т.д.
        return Pattern.compile("([A-Za-z0-9_]{1,25})");
    }
}
