package session13;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.math.BigDecimal;

/**
 * Created by PaHod on 16.06.2014.
 */
public class Main {
    public static void main(String[] args) {
        Session session = session13.HibernateUtil.getSession();
        Employee employee1 = new Employee("Petia1", 23,true);
        Employee employee2 = new Employee("Petia2", 26,false);
        Employee employee3 = new Employee("Petia3", 33,true);
        Employee employee4 = new Employee("Petia4", 63,false);
        Company company1 = new Company("ASUS", BigDecimal.valueOf(233523523));
        Company company2 = new Company("HP", BigDecimal.valueOf(456456456));

        company1.getEmployees().add(employee1);
        company1.getEmployees().add(employee2);
        employee1.setCompany(company1);
        employee2.setCompany(company1);
        company2.getEmployees().add(employee3);
        company2.getEmployees().add(employee4);
        employee3.setCompany(company2);
        employee4.setCompany(company2);



            try {
                session.beginTransaction();
                session.save(company1);
                session.save(company2);
                session.save(employee1);
                session.save(employee2);
                session.save(employee3);
                session.save(employee4);

                session.getTransaction().commit();

            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                session.close();
            }





    }
}
