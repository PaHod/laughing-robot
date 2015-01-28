package dao;

import domain.Producer;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface ProducerDAO {
    void create(Producer producer);

    Producer read(Long id);

    void update(Producer producer);

    void delete(Producer producer);

    List<Producer> findAll();

    List<Producer> findByName(String name);


}
