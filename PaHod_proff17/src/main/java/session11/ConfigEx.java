package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/11/13
 */
public class ConfigEx {
    private static Logger log = Logger.getLogger(ConfigEx.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure("/hibernate.cfg.xml").buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            System.out.println(session);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        log.info(session);
    }
}
