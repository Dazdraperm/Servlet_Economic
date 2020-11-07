package kpfu.itis.group907.Economic.Servlet;

import kpfu.itis.group907.Economic.Helpers.PasswordHelper;
import kpfu.itis.group907.Economic.Models.DefaultUser;
import kpfu.itis.group907.Economic.Service.DefaultUserService;
import kpfu.itis.group907.Economic.Service.Impl.DefaultUserServiceImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name="registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DefaultUserService userService = new DefaultUserServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String rPassword = req.getParameter("rPassword");
        String LAST_NAME = req.getParameter("LAST_NAME");
        String FIRST_NAME = req.getParameter("FIRST_NAME");
        String EMAIL = req.getParameter("EMAIL");

        if (checkPassword(password, rPassword)
                && checkLogin(login)
                && checkFName_LName(FIRST_NAME)
                && checkFName_LName(LAST_NAME)) {

            DefaultUser defaultUser = new DefaultUser(login, PasswordHelper.encrypt(EMAIL, password), LAST_NAME, FIRST_NAME, EMAIL);

            try {
                System.out.println(defaultUser);
                userService.save(defaultUser);
                resp.sendRedirect("/Login.ftl");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            resp.sendRedirect("Registration.ftl");
        }

    }


    private boolean checkLogin(String login){//

        Pattern pattern = loginPatternCompile();
        Matcher matcherPassword = pattern.matcher(login);

        return matcherPassword.matches();

    }

    private boolean checkFName_LName(String name){//


        Pattern pattern = nameLNamePatternCompile();
        Matcher matcherPassword = pattern.matcher(name);

        return matcherPassword.matches();

    }

    //Проверка совпадают ли пароли и совпадает ли пароль с регуляркой
    private boolean checkPassword(String password, String rPassword){//
        if (!password.equals(rPassword)){
            return false;
        }

        Pattern pattern = passwordPatternCompile();
        Matcher matcherPassword = pattern.matcher(password);

        return matcherPassword.matches();

    }

    public static Pattern passwordPatternCompile(){//Не менее 8 символов Содержит хотя бы одну цифру
                                                   // Содержит хотя бы один нижний альфа char и один верхний альфа char
                                                   // Содержит хотя бы один char в наборе специальных символов (@#%$^ и т.д.)
                                                   // Не содержит пробелов, вкладок и т.д.
        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    public static Pattern nameLNamePatternCompile(){//Не менее 8 символов Содержит хотя бы одну цифру
        // Содержит хотя бы один нижний альфа char и один верхний альфа char
        // Содержит хотя бы один char в наборе специальных символов (@#%$^ и т.д.)
        // Не содержит пробелов, вкладок и т.д.
        return Pattern.compile("([A-Za-z]{1,25})");
    }

    public static Pattern loginPatternCompile(){//Не менее 8 символов Содержит хотя бы одну цифру
        // Содержит хотя бы один нижний альфа char и один верхний альфа char
        // Содержит хотя бы один char в наборе специальных символов (@#%$^ и т.д.)
        // Не содержит пробелов, вкладок и т.д.
        return Pattern.compile("([A-Za-z0-9_]{1,25})");
    }


}
