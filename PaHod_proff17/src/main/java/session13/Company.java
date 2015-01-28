package session13;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by PaHod on 16.06.2014.
 */
@Entity
@Table(name = "COMPANY")

public class Company {
    @Id
    @GeneratedValue

    @Column(name = "COMPANY_ID")
    private Long id;
    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_MONEY")
    private BigDecimal money;


    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

    public Company() {
        employees = new HashSet<>();
    }

    public Company(String companyName, BigDecimal money) {
        this.companyName = companyName;
        this.money = money;
        employees = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
