package session10;

import javax.swing.*;
import java.sql.*;
import java.util.Locale;

/**
 * Created by PaHod on 03.06.2014.
 * пользователь вводыт имя департаментв и год, вывести всех сотрудников принятых на работу в данном годи и департаменте.
 *
 * пользователь вводит имя страны, добавить указаную страну в регион европа
 */
public class sqlConnect {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        System.out.println("Application started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e)  {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        Statement statement = null;
        int resultSet;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection established!");
            String counName = JOptionPane.showInputDialog(null, "Уведіть назву рідної країни=)");
            String counId = JOptionPane.showInputDialog(null, "Уведіть ідентифікатор країни=)");
            int regId = Integer.parseInt(JOptionPane.showInputDialog(null, "Уведіть ідентифікатор регіону"));

                statement = conn.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO countries(country_id, country_name, region_id)"+
                    "VALUES ('"+counId+"','"+counName+"','"+regId+"' ) ");
//            resultSet = statement.executeQuery(
//                    "SELECT e.employee_id, e.first_name, e.last_name, d.department_name, e.hire_date " +
//                            "FROM employees e JOIN departments d " +
//                            "ON e.department_id=d.department_id WHERE d.department_name = '" + depName + "' " +
//                            "AND EXTRACT(YEAR FROM e.hire_date) = " + year + " "
//            );
            System.out.println(resultSet);
//            while(resultSet.next()) {
//                long id = resultSet.getLong(1);
//                String firstName = resultSet.getString("FIRST_NAME");
//                String lastName = resultSet.getString("LAST_NAME");
//                String departName = resultSet.getString(4);
//                Date hireDate =  resultSet.getDate(5);
//
//                System.out.printf("%d     %s     %s     %s    %s", id, firstName, lastName, departName, hireDate);
//                System.out.println();
//            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
//            if(resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {}
//            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {}
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}