package com.mageto.duka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame{
    private JLabel login_label;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JPanel main_panel;
    private JLabel username_label;
    private JLabel password_label;


    public login() {
        setContentPane(main_panel);
        setTitle("Duka");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());


            }
        });
    }
    public static void main(String[] args) {
        login myLogin = new login();
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//    }
}
