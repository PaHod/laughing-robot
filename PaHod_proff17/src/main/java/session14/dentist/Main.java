package session14.dentist;

import org.hibernate.SessionFactory;
import session14.dentist.dao.ClientDao;
import session14.dentist.dao.ClientHibernateDaoImpl;
import session14.dentist.dao.DoctorDao;
import session14.dentist.dao.DoctorDaoImpl;
import session14.dentist.service.ClientService;
import session14.dentist.service.ClientServiceImpl;
import session14.dentist.utils.HibernateUtil;
import session14.dentist.view.Menu;


/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        ClientDao clientDao = new ClientHibernateDaoImpl(sessionFactory);
        DoctorDao doctorDao = new DoctorDaoImpl(sessionFactory);
        ClientService clientService = new ClientServiceImpl(clientDao, doctorDao);

        Menu menu = new Menu(clientService);
        menu.main();
    }
}
