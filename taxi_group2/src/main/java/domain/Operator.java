package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Oles on 17.07.2014.
 */
@Entity
@Table (name = "OPERATORS")
public class Operator {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "LOGIN", unique = true)
    private String login;

    @Column(name = "PERSONAL_ID")
    private Integer ipn;

    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_CHANGE")
    private Date lastPassChange;

    public Operator() {}

    public Operator(String login, Integer ipn, String password, Date lastPassChange) {
        this.login = login;
        this.ipn = ipn;
        this.password = password;
        this.lastPassChange = lastPassChange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getIpn() {
        return ipn;
    }

    public void setIpn(Integer ipn) {
        this.ipn = ipn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastPassChange() {
        return lastPassChange;
    }

    public void setLastPassChange(Date lastPassChange) {
        this.lastPassChange = lastPassChange;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", ipn=" + ipn +
                ", password='" + password + '\'' +
                ", lastPassChange=" + lastPassChange +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operator operator = (Operator) o;

        if (!login.equals(operator.login)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
