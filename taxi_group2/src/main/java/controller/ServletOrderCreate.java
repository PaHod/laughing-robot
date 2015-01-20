package controller;


import dao.ClientDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import domain.Client;
import domain.Order;

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
@WebServlet("/ServletOrderCreate")
public class ServletOrderCreate extends HttpServlet {
    private OrderDao orderDao;
    private ClientDaoImpl clientDao;


    @Override
    public void init() throws ServletException {
        orderDao = new OrderDaoImpl();
        clientDao = new ClientDaoImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Map<String, String[]> params = req.getParameterMap();


            String clientId = params.get("client")[0];
            String startAddress = params.get("startAddress")[0];
            String finishAddress = params.get("finishAddress")[0];
            String amount = params.get("amount")[0];
            String date = params.get("date")[0];
            Client client = clientDao.read(Long.valueOf(clientId));
            Order order = new Order(client, new Date(),  Double.valueOf(amount), startAddress, startAddress);
            orderDao.create(order);

            req.setAttribute("answer", "order successful created ");
            req.getRequestDispatcher("/orderManager.jsp").forward(req, resp);


        } else {
            req.setAttribute("answer", "please login");
            req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);
        }
    }
}
