package dao;


import domain.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Oles on 17.07.2014.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public Long create(Client client) {
        Session session = factory.getCurrentSession();
        return (Long) session.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client read(Long id) {
        return (Client) factory.getCurrentSession().get(Client.class, id);
    }

    @Override
    @Transactional
    public void update(Client client) {
        factory.getCurrentSession().update(client);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        factory.getCurrentSession().delete(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        Session session = factory.getCurrentSession();


        return (List<Client>)session.createCriteria(Client.class)
                .list();
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
