package session14.dentist.service;


import session14.dentist.dao.ClientDao;
import session14.dentist.dao.DoctorDao;
import session14.dentist.domain.Client;
import session14.dentist.domain.Doctor;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class ClientServiceImpl implements ClientService {
    private ClientDao userDao;
    private DoctorDao doctorDao;

    public ClientServiceImpl(ClientDao clientDao, DoctorDao docDao) {
        userDao = clientDao;
        doctorDao = docDao;
    }

    @Override
    public List<Client> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addNewUser(String name, String surname, int age, Date date, Long docId, double sum) {


        Doctor doctor = doctorDao.read(docId);

        Client user = new Client(name, surname, age, date, doctor, sum);
        userDao.create(user);


    }

    @Override
    public void addNewDoctor(Doctor doctor) {
        doctorDao.create(doctor);
    }

    @Override
    public List<Client> getClientsByDoctor(Long docId) {



        return null;
    }

    @Override
    public Integer getClientsCountByDoctor(Long docId) {
        return null;
    }
}
