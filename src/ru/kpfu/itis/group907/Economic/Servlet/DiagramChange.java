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
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Сервлет отвечает за работу изменения категорий(name_category можно поменять за 1 раз только единажды, а count_category сколько угодно
@WebServlet(name = "diagramChange", urlPatterns = "/diagramChange")
public class DiagramChange extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login1 = (String) req.getSession().getAttribute("login");
        DiagramDao diagramDao = new DiagramDao(login1);

        //Если try проходит значит мы нашли элемент который нужно менять
        String finalCategory = req.getParameter("name");
        System.out.println(finalCategory);

        try {
            //По ней находим элементы которые надо изменять

            //На что меняем name_category
            String finalCategoryNew = req.getParameterValues(finalCategory)[0];
            System.out.println(finalCategoryNew);
            //На что меняем count_category
            String finalNewCountCategory = req.getParameterValues(finalCategory)[1];
            System.out.println(finalNewCountCategory);
            //Regex проверка
            if (checkCountCategory(finalNewCountCategory) && checkNameCategory(finalCategoryNew)) {

                //Проверки, что меняем не на тоже самое и проверка, что такого имени еще нет в name_categories
                if (finalCategory.equals(finalCategoryNew) || (!diagramDao.getAll().keySet().contains(finalCategoryNew))) {

                    diagramDao.changeCountCategory(finalNewCountCategory, finalCategory);
                    diagramDao.changeCategory(finalCategoryNew, finalCategory);

                } else {
//                    resp.sendRedirect("/Succ.ftl");

                }

            } else {
//                resp.sendRedirect("/Succ.ftl");

            }
        } catch (NullPointerException e) {
//            resp.sendRedirect("/Succ.ftl");
        }
        resp.sendRedirect("/diagram");
    }



    //Функция реализующая проверку name_category
    private boolean checkNameCategory(String nameCategory) {//

        Pattern pattern = nameCategoryPatternCompile();
        Matcher matcherNameCategory = pattern.matcher(nameCategory);

        return matcherNameCategory.matches();

    }

    //Функция реализующая проверку count_category
    private boolean checkCountCategory(String countCategory) {//

        Pattern pattern = countCategoryPatternCompile();
        Matcher matcherNameCategory = pattern.matcher(countCategory);
        return matcherNameCategory.matches();

    }

    //Regex для name_category
    private static Pattern nameCategoryPatternCompile() {//Не менее 8 символов Содержит хотя бы одну цифру
        // Содержит хотя бы один нижний альфа char и один верхний альфа char
        // Содержит хотя бы один char в наборе специальных символов (@#%$^ и т.д.)
        // Не содержит пробелов, вкладок и т.д.
        return Pattern.compile("([A-Za-z0-9_]{1,25})");
    }

    //Regex для count_category
    private static Pattern countCategoryPatternCompile() {//Не менее 8 символов Содержит хотя бы одну цифру
        // Содержит хотя бы один нижний альфа char и один верхний альфа char
        // Содержит хотя бы один char в наборе специальных символов (@#%$^ и т.д.)
        // Не содержит пробелов, вкладок и т.д.
        return Pattern.compile("([0-9_]{1,10})");
    }
}