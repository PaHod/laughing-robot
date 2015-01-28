package session14.dentist.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session14.dentist.domain.Client;
import session14.dentist.utils.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.05.13
 */
public class ClientHibernateDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);
    private SessionFactory factory;

    public ClientHibernateDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Client user) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Client read(Long id) {


        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public List<Client> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Client.class)
                    .list();
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("findAll error", e);
        } finally {
            session.close();
        }


        return null;

    }

    @Override
    public List<Client> findByDoctor() {
        return null;
    }

    /*@Override
    public List<Client> findByDoctorName(String docName) {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Client.class)
                    .createCriteria("doctor")
                    .add(Restrictions.eq("name", docName))
                    .list();
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("findByDoctorName error", e);
        } finally {
            session.close();
        }


        return null;
    }
*/

}
