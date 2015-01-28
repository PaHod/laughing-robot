package dao;

import domain.Notebook;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface NotebookDAO {
    void create(Notebook notebook);
    Notebook read(Long id);
    void update(Notebook notebook);
    void delete(Notebook notebook);
    List<Notebook> findAll();

}
