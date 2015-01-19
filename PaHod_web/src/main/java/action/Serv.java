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

        if(session== null){
            Map<String, String[]> parameterMap = req.getParameterMap();
            String login = parameterMap.get("login")[0];
            String pass = parameterMap.get("pass")[0];
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
                resp.getWriter().println("login: "+session.getAttribute("login") + "  pass: " + session.getAttribute("pass"));
                req.setAttribute("users", "qwerty");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {

/*
                req.setAttribute("return", "");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);*/
                resp.getWriter().println("<html>\n" +
                        "<body>\n" +
                        "<h2 style=\"color: red\"><img src='bye.jpg'/></h2>\n" +
                        "</body>\n" +
                        "</html>\n");
            }


        }else {

            resp.getWriter().println("session exist");
            resp.getWriter().println("login: "+session.getAttribute("login") + "  pass: " + session.getAttribute("pass"));

        }

    }


}
