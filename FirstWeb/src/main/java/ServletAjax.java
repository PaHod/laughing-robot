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
@WebServlet("/ajax")
public class ServletAjax extends HttpServlet {

    private HashMap<String, String> operators; // подтянуть из базы данных


    @Override
    public void init() throws ServletException {
        operators = new HashMap<>();
        operators.put("PaHod", "qwerty");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("111");
        Map<String, String[]> params = req.getParameterMap();
//        String login = params.get("login")[0];
        String pass = params.get("pass")[0];

        resp.getWriter().print("Hello" + login);

//        HttpSession session = req.getSession(false);
//
//            System.out.println("222");
//            if (operators.containsKey(login)&&operators.get(login).equals(pass)) {
//                System.out.println("logined");
//                resp.getWriter().print("<h2>Hello in ajax</h2>");
//
//            }else {
//                req.setAttribute("answer", "incorrect login and/or pass");
//                req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);
//            }


    }
}
