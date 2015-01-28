package session14.dentist.dao;

import session14.dentist.domain.Doctor;

import java.util.List;

/**
 * Created by PaHod on 17.06.2014.
 */
public interface DoctorDao {
    void create(Doctor doctor);
    Doctor read(Long id);
    void update(Doctor doctor);
    void delete(Doctor doctor);
    List<Doctor> findAll();

}
