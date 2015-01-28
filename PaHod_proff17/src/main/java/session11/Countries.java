package session11;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.jms.JMSException;
import java.util.Locale;

/**
 * Created by PaHod on 09.06.2014.
 */
public class Countries {
    private static Logger log = Logger.getLogger(ConfigEx.class);
    // private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ConfigEx.class);

    public static void main(String[] args) throws JMSException {
        Locale.setDefault(Locale.ENGLISH);
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure("/hibernate.cfg.xml").buildSessionFactory();
        log.info("reference to session factory" + factory);
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(new Country("UA", "Ukraine", 1l));
            Country country = (Country) session.get(Country.class, "UA");
            session.getTransaction().commit();
            System.out.println(country);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
