/**
 * 24th Sept 2025

 * Erneste IZERE NEZA (222001299)
 * Nicyogihe Rebeca (223011370)
 * Kangabe Belise (223007011)
 * Musemakweli Muhamed(223004968)
 * Munyarukundo Joseph (223003209)
 * Munezero Grace (223009957)
 * Ndagijimana Aloys (223017789)
 * Umwari Celine (223008405)
 **/

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
        setTitle("Login Form");
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
        try(Connection con = DB.getConnection()) {
            String sql = "Select * FROM user WHERE username =? "+"AND password =?";
            PreparedStatement stm  = con.prepareStatement(sql);
            stm.setString(1, usernametxt.getText());
            stm.setString(2, new String(passwordtxt.getPassword()));
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                String role = rs.getString("role");
                dispose();
                new SMIS(role, rs.getInt("userid"));
            }else{
                JOptionPane.showMessageDialog(this, "Wrong Username or Password");
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
