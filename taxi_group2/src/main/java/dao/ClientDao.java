package dao;

import domain.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oles on 17.07.2014.
 */
@Repository
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    void update(Client client);
    void delete(Client client);
    List findAll();
}
