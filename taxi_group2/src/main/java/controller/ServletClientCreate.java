package controller;

import dao.ClientDaoImpl;
import domain.Client;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by PaHod on 17.07.2014.
 */
@WebServlet("/servletCreateClient")
public class ServletClientCreate extends HttpServlet {

   private ClientDaoImpl clientDao;

    @Override
    public void init() throws ServletException {
      clientDao = new ClientDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Map<String,String[]> params = req.getParameterMap();
            String firstName = params.get("firstName")[0];
            String lastName = params.get("lastName")[0];
            String phone = params.get("lastName")[0];
            String address = params.get("lastName")[0];

            Client client = new Client(firstName, lastName, phone, address);
            clientDao.create(client);
            // - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)

            req.setAttribute("answer", "client successful created ");
            req.getRequestDispatcher("/clientManager.jsp").forward(req, resp);


        }else {
            req.setAttribute("answer", "please login");
            req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);
        }


   }
}
