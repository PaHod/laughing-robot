package session12;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by PaHod on 10.06.2014.
 * добавить в ДАО метод выводящий регионы по имени.
 * добавить в ДАО метод получения по диапазону АЙДишников
 * добавить метод поиска региона по части имени
 */
public class RegionHibernateDaoImpl implements RegionDao {
    private static Logger log =Logger.getLogger(RegionHibernateDaoImpl.class);

    @Override
    public void create(Region region) {
        Session session = HibernateUtil.getSession();
       try{

           session.beginTransaction();
           session.save(region);
           session.getTransaction().commit();
       } catch (HibernateException e){
           log.error("error session", e);
           session.getTransaction().rollback();
       }finally {
           session.close();
       }

    }

    @Override
    public Region read(Long id) {

        Session session = HibernateUtil.getSession();

        try {
            return  (Region)session.get(Region.class, id);
        } catch (HibernateException e) {
            log.error("error", e);

        } finally {
            session.close();
        }


        return null;
    }

    @Override
    public void update(Region region) {
        Session session = HibernateUtil.getSession();

        try{
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();

        }catch(HibernateException e){
            log.error("error conection", e);
            session.getTransaction().rollback();
        }finally {
            session.close();

        }



    }

    @Override
    public void delete(Region region) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("eroor connect", e);
            session.getTransaction().rollback();

        } finally {
            session.close();
        }

    }

    @Override
    public List<Region> findAll() {
        Session session = session12.exemple.HibernateUtil.getSession();
        try {
            return session.createCriteria(Region.class)
                    .list();
        } catch(HibernateException e) {
            log.error("Fetch error", e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Region> findByName(String name) {
        Session session = HibernateUtil.getSession();

        try {
            return session.createCriteria(Region.class)
                    .add(Restrictions.like("name", name))
                    .list();
        } catch (HibernateException e) {
            log.error("error",e);
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<Region> findByPartOfName(String partOfName) {
        Session session = HibernateUtil.getSession();
        partOfName = "%"+ partOfName +"%";
        try {
            return session.createCriteria(Region.class)
                    .add(Restrictions.like("name", partOfName))
                    .list();
        } catch (HibernateException e) {
            log.error("error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public List<Region> findByIdRange(Long firstId, Long lastId) {
        Session session = HibernateUtil.getSession();


        try {
            return session.createCriteria(Region.class)
                    .add(Restrictions.between("id", session.get(Region.class, firstId), session.get(Region.class, lastId)))
                    .list();
        } catch (HibernateException e) {
            log.error("fech error", e);

        } finally {
            session.close();
        }


        return null;
    }
}
