package hw2.authentication;


import hw2.hash.User;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by PaHod on 19.05.2014.
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 * - boolean authenticate() - ввод логина и пароля + проверка
 * - boolean authenticate(String login, String pass)
 * - add(String login, String pass)
 * - remove(String login)
 * <p>
 * Класс задания hw2.authentication.Auth
 */
public class Auth {
    private Map<String, String> users;

    public Auth(){
        users = new HashMap<String, String>();

    }
    public Auth(Map<String, String> users) {
        this.users = users;
    }

    public boolean authenticate() {


        String login = JOptionPane.showInputDialog(null, "Enter login");
        String pass = JOptionPane.showInputDialog(null, "Enter password");
        if (login != null && pass != null&&users.containsKey(login) &&
                    users.get(login).equals(pass)) {
                return true;




        }else {
            System.out.println("login or pass = null");
        }
        return false;
    }

    public boolean authenticate(String login, String pass) {

        if (login != null && pass != null) {
            if (users.containsKey(login) ){

                if(users.get(login).equals( pass)){

                    return true;
                }else {
                    System.out.println("authenticate incorrect pass");
                }


            }else {
                System.out.println("authenticate incorrect log");
            }


        }else {
            System.out.println("login or pass = null");
        }
        return false;
    }

    public void add(String login, String pass) {
        if (login != null && pass != null) {

            if (users.containsKey(login)) {
                System.out.println("this login already in use");
            }else {

                users.put(login, pass);
                System.out.println("user successfull ADDED");
            }

        }else {
            System.out.println("login or pass = null");
        }

    }

    public void remove(String login) {
        if(login!=null){
            if (users.containsKey(login)){
                users.remove(login);
                System.out.println("user successfull DELETED");
            }else {
                System.out.println("this user does not exist");
            }

        }else {
            System.out.println("login is null");
        }
    }


}
