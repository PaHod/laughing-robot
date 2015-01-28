package dao;

import domain.RAM;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface RamDAO {
    void create(RAM RAM);
    RAM read(Long id);
    void update(RAM RAM);
    void delete(RAM RAM);
    List<RAM> findAll();
}
