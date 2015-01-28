package dao;

import domain.ROM;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface RomDAO {
    void create(ROM ROM);
    ROM read(Long id);
    void update(ROM ROM);
    void delete(ROM ROM);
    List<ROM> findAll();
}
