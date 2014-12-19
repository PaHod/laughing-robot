/*
package hw5.auth;

import javax.swing.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

*/
/**
 * Created by PaHod on 09.06.2014.
 *//*

public class UserJDBCManager {
    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Start");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not foud");
            return;
        }
        System.out.println("driver loaded");
        Connection conn = null;
        Statement statement=  null;
        int result;
        String url = "jdbc.oracle:thin:@localhost:1521:XE";
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn = DriverManager.getConnection(url, "hr", "hr");
        System.out.println("connect ok");
        //String counName = JOptionPane.showInputDialog(null, "Уведіть назву рідної країни=)");
//        int regId = Integer.parseInt(JOptionPane.showInputDialog(null, "Уведіть ідентифікатор регіону"));
        result = statement.executeUpdate();



    }






}


*/
