package dao;

import domain.Processor;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface ProcessorDAO {
    void create(Processor processor);
    Processor read(Long id);
    void update(Processor processor);
    void delete(Processor processor);
    List<Processor> findAll();
}
