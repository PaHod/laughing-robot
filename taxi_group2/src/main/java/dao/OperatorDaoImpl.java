package dao;

import domain.Operator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PaHod on 17.07.2014.
 */
@Repository
public class OperatorDaoImpl implements OperatorDao {

    @Autowired
    private SessionFactory factory;


    @Override
    @Transactional
    public Long create(Operator operator) {
        return (Long) factory.getCurrentSession().save(operator);
    }

    @Override
    @Transactional(readOnly = true)
    public Operator read(Long id) {
        return (Operator) factory.getCurrentSession().get(Operator.class, id);
    }

    @Override
    @Transactional
    public void update(Operator operator) {
        factory.getCurrentSession().update(operator);
    }

    @Override
    @Transactional
    public void delete(Operator operator) {
        factory.getCurrentSession().delete(operator);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Operator> findAll() {
        return factory.getCurrentSession().createCriteria(Operator.class).list();
    }

    @Override
    public Operator findByLogin(String login) {
        return (Operator) factory.getCurrentSession().createCriteria(Operator.class).add(Restrictions.eq("login", login));
    }

    @Override
    public boolean checkOperator(String login, String password) {
        Operator operator = (Operator) factory.getCurrentSession().createCriteria(Operator.class)
                .add(Restrictions.eq("login", login)).add(Restrictions.eq("password", password));
        return operator!=null;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
