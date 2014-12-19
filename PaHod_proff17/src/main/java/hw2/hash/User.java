package hw2.hash;

import java.util.Date;

/**
 * Created by PaHod on 18.05.2014.
 * <p>
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 * Поля класса пользователь:
 * 1. Логин
 * 2. Пароль
 * 3. Дата регистрации
 * 4. Рейтинг (вещественное число)
 * 5. Пол
 * <p>
 * Класс задания hw2.hash.User
 */
public class User {
    private String login;
    private String pass;
    private Date regDate;
    private Double rating;
    private Boolean sex;

    public User() {
        this.regDate = new Date();
    }

    public User(String logIn, String pass, Date regDate, boolean sex) {
        this.login = logIn;
        this.pass = pass;
        this.regDate = regDate;
        this.rating = 0.0;
        this.sex = sex;
    }

    @Override
    public int hashCode() {

        return this.login.hashCode()*31 + this.pass.hashCode()*17 + this.regDate.hashCode()*3 +
                +this.rating.hashCode()*19 + this.sex.hashCode()*11;
    }

    @Override
    public boolean equals(Object obj) {

        if (this.hashCode() == obj.hashCode() && this.getClass().equals(obj.getClass())) {
            User user = (User) obj;
            if (login.equals(user.getLogin()) && pass.equals(user.getPass()) &&
                    regDate.equals(user.getRegDate()) && rating.equals(user.getRating())
                    && sex.equals(user.isSex())) {
                return true;
            }


        }


        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


}
