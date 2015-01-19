package action.hw9;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PaHod on 07.07.2014.
 * Написать сервлет для аутентификации пользователей.
 * Если логин и пароль введен верно, то начинаем сеанс с пользователем и запоминаем его логин.
 * Если логин или пароль введен неверно, то возвращаем пользователя на форму аутентификации и над соответствующим полем указываем красным "логин/пароль введен неверно".
 * Если пользователь ввел несуществующий логин, то возвращаем на пустую форму аутенификации.
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    private HashMap<String, String> users;

    @Override
    public void init(ServletConfig config) {
        this.users = new HashMap<>();
        this.users.put("log", "pass");
        this.users.put("log1", "pass1");
        this.users.put("log2", "pass2");
        this.users.put("log3", "pass3");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            Map<String, String[]> parametrMap = req.getParameterMap();
            String login = parametrMap.get("login")[0];
            String pass = parametrMap.get("pass")[0];
            if (users.containsKey(login) && users.get(login).equals(pass)) {
                resp.getWriter().println("<html>\n" +
                        "<body>\n" +
                        "<h2 style=\"color: red\">yes</h2>\n" +
                        "</body>\n" +
                        "</html>\n");

                session = req.getSession();
                session.setMaxInactiveInterval(7);
                resp.getWriter().println("session create");

                session.setAttribute("login", login);
                session.setAttribute("pass", pass);
                resp.getWriter().println("login: " + session.getAttribute("login") + "  pass: " + session.getAttribute("pass"));
                req.setAttribute("users", "qwerty");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {


                resp.getWriter().println("<html>\n" +
                        "<body>\n" +
                        "<h2 style=\"color: red\"><img src='bye.jpg'/></h2>\n" +
                        "</body>\n" +
                        "</html>\n");
            }


        } else {

            resp.getWriter().println("session exist");
            resp.getWriter().println("login: " + session.getAttribute("login") + "  pass: " + session.getAttribute("pass"));

        }


    }
}


