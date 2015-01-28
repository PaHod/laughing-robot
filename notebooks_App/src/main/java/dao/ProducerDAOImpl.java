package dao;

import domain.Producer;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;


/**
 * Created by PaHod on 24.01.2015.
 */
public class ProducerDAOImpl implements ProducerDAO {
    private static Logger logger = Logger.getLogger(ProducerDAOImpl.class);

    public ProducerDAOImpl(SessionFactory factory) {

    }

    @Override
    public void create(Producer producer) {
        Session session = HibernateUtil.getSession();

        try {

            session.beginTransaction();
            session.save(producer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.error("producer create error", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }


    }

    @Override
    public Producer read(Long id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Producer) session.get(Producer.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.error("producer read error", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Producer producer) {


    }

    @Override
    public void delete(Producer producer) {

    }

    @Override
    public List<Producer> findAll() {
        return null;
    }

    @Override
    public List<Producer> findByName(String name) {
        Session session = HibernateUtil.getSession();
        try {

            return (List<Producer>)session.createCriteria(Producer.class)
                    .add(Restrictions.eq("name", name))
                    .list();
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.error("producer read error", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }
}
