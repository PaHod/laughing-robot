package session13;

import javax.persistence.*;

/**
 * Created by PaHod on 16.06.2014.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue

    @Column(name = "EMPLOYEE_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    private Boolean sex;

    @ManyToOne
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee() {
    }

    public Employee(String name, Integer age, Boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.company = company;
    }
}
