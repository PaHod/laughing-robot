package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by PaHod on 20.01.2015.
 */
@Entity
@Table (name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surName;
    private String adderes;
    private int mobilePhone;
    private int workPhone;
    private Date birthDate;
    private Double salary;


}
