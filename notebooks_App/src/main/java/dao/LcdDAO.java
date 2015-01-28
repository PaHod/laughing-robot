package dao;

import domain.LCD;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface LcdDAO {
    void create(LCD LCD);
    LCD read(Long id);
    void update(LCD LCD);
    void delete(LCD LCD);
    List<LCD> findAll();
}
