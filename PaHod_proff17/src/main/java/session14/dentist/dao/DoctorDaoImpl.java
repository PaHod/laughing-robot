package session14.dentist.dao;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session14.dentist.domain.Doctor;
import session14.dentist.utils.HibernateUtil;

import java.util.List;

/**
 * Created by PaHod on 17.06.2014.
 */
public class DoctorDaoImpl implements DoctorDao {
    private static Logger log = Logger.getLogger(DoctorDaoImpl.class);
    private SessionFactory factory;

    public DoctorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("doc create error", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public Doctor read(Long id) {

        Session session = HibernateUtil.getSession();
        try {

            return (Doctor)session.get(Doctor.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("doc create error", e);

        } finally {
            session.close();
        }


        return null;
    }

    @Override
    public void update(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(doctor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("doc update error", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }


    }

    @Override
    public void delete(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(doctor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("doc delete error", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }


    }

    @Override
    public List<Doctor> findAll() {
        Session session = HibernateUtil.getSession();
        try {

            return session.createCriteria(Doctor.class).list();

        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("doc find all error", e);

        } finally {
            session.close();
        }


        return null;
    }
}
