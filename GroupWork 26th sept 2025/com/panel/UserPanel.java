package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserPanel extends JPanel implements ActionListener {
    JTextField idTxt = new JTextField(), nameTxt = new JTextField(), phoneTxt = new JTextField(),
            emailtxt = new JTextField(), roleIdTxt = new JTextField();
    JPasswordField passTxt = new JPasswordField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"), deletebtn = new JButton("Delete"),
            loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    public UserPanel() {
        setLayout(null);
        String[] labels = {"UserID", "Username", "Password", "Phone", "Email", "RoleID"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 900, 400);

        int y = 20;
        addField("UserID", idTxt, y);
        y = 50;
        addField("Username", nameTxt, y);
        y = 80;
        addField("Password", passTxt, y);
        y = 110;
        addField("Phone", phoneTxt, y);
        y = 140;
        addField("Email", emailtxt, y);
        y = 170;
        addField("RoleID", roleIdTxt, y);

        addButtons();
        add(sp);
    }

    private void addButtons() {
        addbtn.setBounds(300, 20, 100, 30);
        updatebtn.setBounds(300, 60, 100, 30);
        deletebtn.setBounds(300, 100, 100, 30);
        loadbtn.setBounds(300, 140, 100, 30);
        add(addbtn); add(updatebtn); add(deletebtn); add(loadbtn);

        addbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        deletebtn.addActionListener(this);
        loadbtn.addActionListener(this);
    }

    private void addField(String lbl, JComponent txt, int y) {
        JLabel l = new JLabel(lbl);
        l.setBounds(20, y, 80, 25);
        txt.setBounds(100, y, 150, 25);
        add(l); add(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()) {
            if (e.getSource() == addbtn) {
                String sql = "INSERT INTO user (Username, Password, Phone, Email, RoleID) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setString(2, new String(passTxt.getPassword()));
                ps.setString(3, phoneTxt.getText());
                ps.setString(4, emailtxt.getText());
                ps.setInt(5, Integer.parseInt(roleIdTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "User added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                String sql = "UPDATE user SET Username=?, Password=?, Phone=?, Email=?, RoleID=? WHERE UserID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setString(2, new String(passTxt.getPassword()));
                ps.setString(3, phoneTxt.getText());
                ps.setString(4, emailtxt.getText());
                ps.setInt(5, Integer.parseInt(roleIdTxt.getText()));
                ps.setInt(6, Integer.parseInt(idTxt.getText()));
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "User updated successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!");
                }

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM user WHERE UserID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idTxt.getText()));
                int rows = ps.executeUpdate();
                if (rows > 0) {
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
                            rs.getInt("UserID"),
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getString("Phone"),
                            rs.getString("Email"),
                            rs.getInt("RoleID")
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
        idTxt.setText(""); nameTxt.setText(""); passTxt.setText("");
        phoneTxt.setText(""); emailtxt.setText(""); roleIdTxt.setText("");
    }
}