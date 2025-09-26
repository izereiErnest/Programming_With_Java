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

package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserPanel extends JPanel implements ActionListener {
    //components
    JTextField idTxt = new JTextField(), nameTxt = new JTextField(), phoneTxt = new JTextField(),
            emailtxt = new JTextField(), roletxt = new JTextField();
    JPasswordField passTxt = new JPasswordField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"), deletebtn = new JButton("Delete"),
            loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    //Constructor
    public UserPanel() {
        setLayout(null);
        String[] labels = {"ID", "Name", "Password", "Phone", "Email", "Role"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 800, 300);
        int y = 20;
        addField("ID", idTxt, y);
        y = 50;
        addField("Name", nameTxt, y);
        y = 80;
        addField("Password", passTxt, y);
        y = 110;
        addField("Phone", phoneTxt, y);
        y = 140;
        addField("Email", emailtxt, y);
        y = 170;
        addField("Role", roletxt, y);
        addButtons();
        add(sp);
    }

    private void addButtons() {
        addbtn.setBounds(300, 20, 100, 30);
        updatebtn.setBounds(300, 60, 100, 30);
        deletebtn.setBounds(300, 100, 100, 30);
        loadbtn.setBounds(300, 140, 100, 30);
        add(addbtn);
        add(updatebtn);
        add(deletebtn);
        add(loadbtn);
        addbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        deletebtn.addActionListener(this);
        loadbtn.addActionListener(this);
    }

    private void addField(String lbl, JComponent txt, int y) {
        JLabel l = new JLabel(lbl);
        l.setBounds(20, y, 80, 25);
        txt.setBounds(100, y, 150, 25);
        add(l);
        add(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()) {
            if (e.getSource() == addbtn) {
                // Fixed SQL - added userid parameter and corrected parameter count
                String sql = "INSERT INTO user (userid, username, password, phone, email, role) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idTxt.getText()));
                ps.setString(2, nameTxt.getText());
                ps.setString(3, new String(passTxt.getPassword()));
                ps.setString(4, phoneTxt.getText());
                ps.setString(5, emailtxt.getText());
                ps.setString(6, roletxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "User added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                // Fixed SQL - added password field and corrected parameter order
                String sql = "UPDATE user SET username=?, password=?, phone=?, email=?, role=? WHERE userid=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setString(2, new String(passTxt.getPassword()));
                ps.setString(3, phoneTxt.getText());
                ps.setString(4, emailtxt.getText());
                ps.setString(5, roletxt.getText());
                ps.setInt(6, Integer.parseInt(idTxt.getText()));
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "User updated successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!");
                }

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM user WHERE userid=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idTxt.getText()));
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "User deleted successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!");
                }

            } else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                String sql = "SELECT * FROM user";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("userid"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getString("role")
                    });
                }
                JOptionPane.showMessageDialog(this, "Data loaded successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idTxt.setText("");
        nameTxt.setText("");
        passTxt.setText("");
        phoneTxt.setText("");
        emailtxt.setText("");
        roletxt.setText("");
    }
}