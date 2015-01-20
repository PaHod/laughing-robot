package action;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by PaHod on 30.06.2014.
 */
@WebServlet("/serv")
public class Serv extends HttpServlet {
    private HashMap<String, String> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.users = new HashMap<>();
        this.users.put("log", "pass");
        this.users.put("log1", "pass1");
        this.users.put("log2", "pass2");
        this.users.put("log3", "pass3");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null) {
            Map<String, String[]> parameterMap = req.getParameterMap();
            String login = parameterMap.get("login")[0];
            String pass = parameterMap.get("pass")[0];
            if (users.containsKey(login) && users.get(login).equals(pass)) {


                session = req.getSession();
                session.setMaxInactiveInterval(15);

                session.setAttribute("login", login);

                String answer = "Welcome, you are logged with login: "  + session.getAttribute("login");
                req.setAttribute("answer", answer);


                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {
                resp.getWriter().println("<html>\n" +
                        "<body>\n" +
                        "<h2 style=\"color: red\"><img src='bye.jpg'/></h2>\n" +
                        "</body>\n" +
                        "</html>\n");
            }
        } else {

            String answer = "You are already logged with login: " + session.getAttribute("login") + "  pass: " + session.getAttribute("pass");
            req.setAttribute("answer", answer);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }


}
