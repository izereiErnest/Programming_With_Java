package com.form;

import com.utils.DB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JFrame implements ActionListener {
    JTextField usernametxt = new JTextField("Enter your Username");
    JPasswordField passwordtxt = new JPasswordField("Enter your Password");
    JButton loginbtn = new JButton("Login");
    JButton cancelbtn = new JButton("Cancel");

    public LoginForm(){
        setTitle("Immigration Passport System - Login");
        setBounds(100, 100, 300, 200);
        setLayout(null);
        usernametxt.setBounds(30, 30, 200, 30);
        passwordtxt.setBounds(30, 70, 200, 30);
        loginbtn.setBounds(30, 120, 100, 30);
        cancelbtn.setBounds(150, 120, 100, 30);
        add(usernametxt); add(passwordtxt); add(loginbtn); add(cancelbtn);

        loginbtn.addActionListener(this);
        cancelbtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelbtn){
            System.exit(0);
        }

        try(Connection con = DB.getConnection()) {
            String sql = "SELECT u.*, r.RoleName FROM user u JOIN role r ON u.RoleID = r.RoleID WHERE username =? AND password =?";
            PreparedStatement stm  = con.prepareStatement(sql);
            stm.setString(1, usernametxt.getText());
            stm.setString(2, new String(passwordtxt.getPassword()));
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                String role = rs.getString("RoleName");
                dispose();
                new IAPS(role, rs.getInt("UserID"));
            }else{
                JOptionPane.showMessageDialog(this, "Wrong Username or Password");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }
}