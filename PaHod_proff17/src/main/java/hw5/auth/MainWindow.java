package hw5.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PaHod on 09.06.2014.
 * <p/>
 * Написать приложение, позволяющее добавлять нового пользователя
 * и просматривать список существующих пользователей. Структура таблицы (id, имя, пароль, дата).
 */
public class MainWindow extends JFrame {

    private JTextField userIdFld;
    private JTextField userNameFld;
    private JTextField passFld;
    private JButton createUserBtn;
    private JButton checkBtn;
    private JButton getAllBtn;

    private boolean flag = true;


    public MainWindow(String title) {
        setTitle(title);
        setLayout(new FlowLayout());
        setBounds(500, 200, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        userNameFld = new JTextField();
        userNameFld.setPreferredSize(new Dimension(100, 30));
        passFld = new JTextField();
        passFld.setPreferredSize(new Dimension(100, 30));

        createUserBtn = new JButton("Create user");
        getAllBtn = new JButton("Get all users");
        checkBtn = new JButton("check user name");

        add(userNameFld);
        add(passFld);
        add(createUserBtn);
        add(getAllBtn);
        add(checkBtn);


       createUserBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }
       });
        getAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }


    public static void main(String[] args) {
        new MainWindow("Counter");
    }
}
