package dao;

import domain.Operator;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oles on 17.07.2014.
 */
@Repository
public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long id);
    void update(Operator operator);
    void delete(Operator operator);
    List<Operator> findAll();
    Operator findByLogin(String login);
    boolean checkOperator(String login, String password);
 //   boolean thisLoginIsFree(String login);
}
