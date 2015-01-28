package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.swing.*;
import java.util.Locale;

/**
 * Created by PaHod on 09.06.2014.
 * создать отображение для таблици coutries
 *
 */
public class Regions {
    private static Logger log = Logger.getLogger(ConfigEx.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure("/hibernate.cfg.xml").buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            session.beginTransaction();
            Long id = (Long)session.save(new Region("Antarctida"));
            session.getTransaction().commit();

            String regionName = JOptionPane.showInputDialog(null, "Введите имя региона");
            Region regionArct = (Region)session.get(Region.class, id);
            regionArct.setName(regionName);

            session.beginTransaction();
            session.update(regionArct);
            session.getTransaction().commit();

            Region region = (Region)session.get(Region.class, id);
            System.out.println(region);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }

    }
}
