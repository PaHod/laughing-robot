package controller;

import dao.OperatorDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PaHod on 17.07.2014.
 */
@WebServlet("/servletOperatorAuth")
public class ServletOperatorAuth extends HttpServlet {

    private WebApplicationContext context;
    private OperatorDao operatorDao;

    private HashMap<String, String> operators; // подтянуть из базы данных

    private Integer sessionTime;

    @Override
    public void init() throws ServletException {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        operatorDao = (OperatorDao) context.getBean("operatorDao");
        operators = new HashMap<>();
        operators.put("Login", "Password1");
        sessionTime =(Integer) context.getBean("sessionTime");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession(false);
        if (session == null) {
            Map<String, String[]> params = req.getParameterMap();
            String login = params.get("login")[0];
            String pass = params.get("pass")[0];
            if (operatorDao.checkOperator(login, pass)) {
                session = req.getSession();
                session.setMaxInactiveInterval(sessionTime);
                req.setAttribute("answer", "welcome");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);

            }else {
                req.setAttribute("answer", "incorrect login and/or pass");
                req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("answer", "already logged");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}
