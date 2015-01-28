package dao;

import domain.Category;

import java.util.List;

/**
 * Created by PaHod on 24.01.2015.
 */
public interface CategoryDAO {
    void create(Category category);
    Category read(Long id);
    void update(Category category);
    void delete(Category category);
    List<Category> findAll();
}
