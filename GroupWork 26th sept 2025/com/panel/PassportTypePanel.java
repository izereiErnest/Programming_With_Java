package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PassportTypePanel extends JPanel implements ActionListener {
    JTextField idTxt = new JTextField(), nameTxt = new JTextField(),
            validityTxt = new JTextField(), feeTxt = new JTextField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"),
            deletebtn = new JButton("Delete"), loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    public PassportTypePanel() {
        setLayout(null);
        String[] labels = {"PassportTypeID", "TypeName", "ValidityYears", "Fee"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 150, 900, 400);

        int y = 20;
        addField("TypeID", idTxt, y);
        y = 50;
        addField("TypeName", nameTxt, y);
        y = 80;
        addField("ValidityYears", validityTxt, y);
        y = 110;
        addField("Fee", feeTxt, y);

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
                String sql = "INSERT INTO passporttype (TypeName, ValidityYears, Fee) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setInt(2, Integer.parseInt(validityTxt.getText()));
                ps.setDouble(3, Double.parseDouble(feeTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passport Type added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                String sql = "UPDATE passporttype SET TypeName=?, ValidityYears=?, Fee=? WHERE PassportTypeID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameTxt.getText());
                ps.setInt(2, Integer.parseInt(validityTxt.getText()));
                ps.setDouble(3, Double.parseDouble(feeTxt.getText()));
                ps.setInt(4, Integer.parseInt(idTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passport Type updated successfully!");
                clearFields();

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM passporttype WHERE PassportTypeID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passport Type deleted successfully!");
                clearFields();

            } else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                String sql = "SELECT * FROM passporttype";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("PassportTypeID"),
                            rs.getString("TypeName"),
                            rs.getInt("ValidityYears"),
                            rs.getDouble("Fee")
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idTxt.setText(""); nameTxt.setText(""); validityTxt.setText(""); feeTxt.setText("");
    }
}