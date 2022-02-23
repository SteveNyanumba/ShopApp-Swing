package com.mageto.duka;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;


public class ListItems extends JFrame {
    private JTable table1;
    private JLabel titleLabel;
    private JPanel list_items_panel;
    private JTextField item_name;
    private JTextField item_description;
    private JTextField item_price;
    private JButton addNewItemButton;
    private JButton loadDataButton;
    private JLabel error_message;
    String[] columnNames = {"ID", "Item Name", "Item Description", "Item Price"};


    public ListItems() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Tamara_Mageto_145280", "root", "");
            PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM tbl_items");
            ResultSet rs = stmt2.executeQuery();
            int count = rs.getMetaData().getColumnCount();
            Vector column = new Vector(count);

            for (int i = 1; i <= count; i++){
                column.add(rs.getMetaData().getColumnName(i));
            }
            Vector data = new Vector();
            Vector row = new Vector();

            while(rs.next()){
                row = new Vector(count);
                for (int i = 1; i <=count; i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }

            table1 = new JTable(data, column);
            JScrollPane jsp = new JScrollPane(table1);
            list_items_panel.setLayout(new BorderLayout());
            list_items_panel.add(jsp, BorderLayout.CENTER);
            setContentPane(list_items_panel);
            setTitle("Duka");
            error_message.setText("");
            setResizable(false);
            setSize(1280, 720);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);




        }catch(SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = item_name.getText();
                String description = item_description.getText();
                Float price = Float.parseFloat(item_price.getText());
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Tamara_Mageto_145280", "root", "");
                    PreparedStatement stmt = connection.prepareStatement("INSERT INTO tbl_items(item_name,item_description,item_price) VALUES(?,?,?)");
                    stmt.setString(1,name);
                    stmt.setString(2,description);
                    stmt.setFloat(3,price);
                    stmt.execute();
                    connection.close();
                }catch(SQLException | NumberFormatException | ClassNotFoundException exception){
                    exception.printStackTrace();
                }
            }
        });

        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_Tamara_Mageto_145280", "root", "");
                    PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM tbl_items");
                    ResultSet rs = stmt2.executeQuery();
                    int count = rs.getMetaData().getColumnCount();
                    Vector column = new Vector(count);

                    for (int i = 1; i <= count; i++){
                        column.add(rs.getMetaData().getColumnName(i));
                    }
                    Vector data = new Vector();
                    Vector row = new Vector();

                    while(rs.next()){
                        row = new Vector(count);
                        for (int i = 1; i <=count; i++){
                            row.add(rs.getString(i));
                        }
                        data.add(row);
                    }





                }catch(SQLException | ClassNotFoundException exception){
                    exception.printStackTrace();
                }
            }
        });




    }
    public static void main(String[] args) {
        ListItems listItems = new ListItems();
    }
}
