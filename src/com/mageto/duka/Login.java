package com.mageto.duka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame{
    private JLabel login_label;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JPanel main_panel;
    private JLabel username_label;
    private JLabel password_label;


    public Login() {
        setContentPane(main_panel);
        setTitle("Duka");
        setResizable(false);
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = passwordField1.getText();

                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Tamara_Mageto_145280", "root", "");
                    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password = ?");
                    stmt.setString(1,username);
                    stmt.setString(2,password);

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()){
                        dispose();
                        ListItems li = new ListItems();
//                        li.setTitle("Welcome"+username);

                    }
                }catch(SQLException sqlException){
                    sqlException.printStackTrace();
                }


            }
        });
    }
    public static void main(String[] args) {
        Login myLogin = new Login();
    }

}
