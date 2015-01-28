package session14.dentist.service;



import session14.dentist.domain.Client;
import session14.dentist.domain.Doctor;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.05.13
 */
public interface ClientService {
    List<Client> getAllUsers();
    void addNewUser(String name, String surname, int age, Date date, Long docId, double sum);
    void addNewDoctor(Doctor doctor);
    List<Client> getClientsByDoctor(Long docId);
    Integer getClientsCountByDoctor(Long docId);

}
