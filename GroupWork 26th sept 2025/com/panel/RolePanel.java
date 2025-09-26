package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RolePanel extends JPanel implements ActionListener {
    JTextField idTxt = new JTextField(), nameTxt = new JTextField(), descTxt = new JTextField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"),
            deletebtn = new JButton("Delete"), loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    public RolePanel() {
        setLayout(null);
        String[] labels = {"RoleID", "RoleName", "RoleDescription"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 150, 900, 400);

        int y = 20;
        addField("RoleID", idTxt, y);
        y = 50;
        addField("RoleName", nameTxt, y);
        y = 80;
        addField("Description", descTxt, y);

        addButtons();
        add(sp);
    }

    private void addButtons() {
        addbtn.setBounds(300, 20, 100, 30);
        updatebtn.setBounds(300, 60, 100, 30);
        deletebtn.setBounds(300, 100, 100, 30);
        loadbtn.setBounds(420, 20, 100, 30);
        add(addbtn); add(updatebtn); add(deletebtn); add(loadbtn);

        addbtn.addActionListener(this); updatebtn.addActionListener(this);
        deletebtn.addActionListener(this); loadbtn.addActionListener(this);
    }

    private void addField(String lbl, JComponent txt, int y) {
        JLabel l = new JLabel(lbl);
        l.setBounds(20, y, 100, 25);
        txt.setBounds(120, y, 150, 25);
        add(l); add(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()) {
            if (e.getSource() == addbtn) {
                String sql = "INSERT INTO role (RoleName, RoleDescription) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setString(2, descTxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Role added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                String sql = "UPDATE role SET RoleName=?, RoleDescription=? WHERE RoleID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setString(2, descTxt.getText());
                ps.setInt(3, Integer.parseInt(idTxt.getText()));
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Role updated successfully!");
                    clearFields();
                }

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM role WHERE RoleID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Role deleted successfully!");
                clearFields();

            } else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                String sql = "SELECT * FROM role";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("RoleID"),
                            rs.getString("RoleName"),
                            rs.getString("RoleDescription")
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idTxt.setText(""); nameTxt.setText(""); descTxt.setText("");
    }
}