package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PaHod on 18.07.2014.
 */
@WebServlet("/servletOrderEdit")
public class ServletOrderEdit extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        req.setAttribute("answer", "welcome");
        req.getRequestDispatcher("/orderManager.jsp").forward(req, resp);

        super.doGet(req, resp);
    }
}
