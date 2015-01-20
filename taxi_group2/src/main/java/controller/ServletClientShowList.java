package controller;

import dao.ClientDao;
import dao.ClientDaoImpl;
import domain.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by PaHod on 17.07.2014.
 */
@WebServlet("/showClientList")
public class ServletClientShowList extends HttpServlet{
    private List<Client> clients;
    ClientDao clientDao;
    int numOfClients=10;

    @Override
    public void init() throws ServletException {
        clientDao = new ClientDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {

            clients = (List<Client>) clientDao.findAll();

            //- вывести всех клиентов порциями по 10 человек (размер порции задается в properties файле)


            req.setAttribute("numOfClients", numOfClients);
            req.setAttribute("Clients", clients);
            req.getRequestDispatcher("/clientManager.jsp").forward(req, resp);
        }else {
            req.setAttribute("answer", "please login");
            req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);
        }
    }
}
