package hw5.auth;

import java.util.Date;

/**
 * Created by PaHod on 09.06.2014.
 */
public class User {
    private int id;
    private String userName;
    private String pass;
    private Date hireDate;

    public User() {

    }

    public User(int id, String userName, String pass, Date hireDate) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.hireDate = hireDate;
    }




}
