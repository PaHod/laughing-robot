package controller;

import dao.OperatorDao;
import dao.OperatorDaoImpl;
import domain.Operator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by PaHod on 17.07.2014.
 */
@WebServlet("/servletOperatorRegistration")
public class ServletOperatorRegistration extends HttpServlet {
    private OperatorDao operatorDao;
    private WebApplicationContext context;
    private String answer;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        operatorDao = new OperatorDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (context != null) {

            HttpSession session = req.getSession(false);
            if (session == null) {

                Map<String, String[]> params = req.getParameterMap();
                String login = params.get("login")[0];
                String ipn = params.get("ipn")[0];
                String pass = params.get("pass")[0];
                String confirmPass = params.get("confirmPass")[0];
                if (pass.equals(confirmPass)) {
                    if (validatePass(pass)) {
                        if (validateLogin(login)) {
                            Operator operator = new Operator(login, Integer.valueOf(ipn), pass, new Date());
                            operatorDao.create(operator);
                            req.setAttribute("answer", "operator successfull create");
                            req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);

                        } else {
                            req.setAttribute("answer", "login already in use or must be longer 4 letters");
                            req.getRequestDispatcher("/registrationForm.jsp").forward(req, resp);
                        }
                    } else {
                        req.setAttribute("answer", "pass must be longer 8 letters and contains: A-Z, a-a, 0-9 ");
                        req.getRequestDispatcher("/registrationForm.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("answer", "pass not confirm");
                    req.getRequestDispatcher("/registrationForm.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("answer", "already logged");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            resp.getWriter().print("Error: Context not found!");
        }
    }

    private boolean validateLogin(String login) {
        if (login.length() >= 4 && login.length() < 20 && operatorDao.findByLogin(login) == null) {
            return true;
        }
        return false;
    }

    private boolean validatePass(String pass) {
        String hiLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowLetters = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "1234567890";
        boolean checkHi = false;
        boolean checkLow = false;
        boolean checkNumb = false;
        int length = pass.length();
        if (length >= 8 && length < 20) {
            int i = 0;
            while (i < length) {
                if (!checkHi && hiLetters.contains(String.valueOf(pass.charAt(i)))) {
                    checkHi = true;
                }
                if (!checkLow && lowLetters.contains(String.valueOf(pass.charAt(i)))) {
                    checkLow = true;
                }
                if (!checkNumb && numbers.contains(String.valueOf(pass.charAt(i)))) {
                    checkNumb = true;
                }
                if (checkHi && checkLow && checkNumb) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
