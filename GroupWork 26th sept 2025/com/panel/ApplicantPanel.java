package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ApplicantPanel extends JPanel implements ActionListener {
    JTextField idTxt = new JTextField(), nationalIdTxt = new JTextField(), nameTxt = new JTextField(),
            dobTxt = new JTextField(), genderTxt = new JTextField(), addressTxt = new JTextField(),
            phoneTxt = new JTextField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"),
            deletebtn = new JButton("Delete"), loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    public ApplicantPanel() {
        setLayout(null);
        String[] labels = {"ApplicantID", "NationalID", "FullName", "DateOfBirth", "Gender", "Address", "Phone"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 900, 400);

        int y = 20;
        addField("ApplicantID", idTxt, y);
        y = 50;
        addField("NationalID", nationalIdTxt, y);
        y = 80;
        addField("FullName", nameTxt, y);
        y = 110;
        addField("DateOfBirth", dobTxt, y);
        y = 140;
        addField("Gender", genderTxt, y);
        y = 170;
        addField("Address", addressTxt, y);
        y = 200;
        addField("Phone", phoneTxt, y);

        addButtons();
        add(sp);
    }

    private void addButtons() {
        addbtn.setBounds(300, 20, 100, 30);
        updatebtn.setBounds(300, 60, 100, 30);
        deletebtn.setBounds(300, 100, 100, 30);
        loadbtn.setBounds(300, 140, 100, 30);
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
                String sql = "INSERT INTO applicant (NationalID, FullName, DateOfBirth, Gender, Address, Phone) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nationalIdTxt.getText());
                ps.setString(2, nameTxt.getText());
                ps.setString(3, dobTxt.getText());
                ps.setString(4, genderTxt.getText());
                ps.setString(5, addressTxt.getText());
                ps.setString(6, phoneTxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Applicant added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                String sql = "UPDATE applicant SET NationalID=?, FullName=?, DateOfBirth=?, Gender=?, Address=?, Phone=? WHERE ApplicantID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nationalIdTxt.getText());
                ps.setString(2, nameTxt.getText());
                ps.setString(3, dobTxt.getText());
                ps.setString(4, genderTxt.getText());
                ps.setString(5, addressTxt.getText());
                ps.setString(6, phoneTxt.getText());
                ps.setInt(7, Integer.parseInt(idTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Applicant updated successfully!");
                clearFields();

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM applicant WHERE ApplicantID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Applicant deleted successfully!");
                clearFields();

            } else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                String sql = "SELECT * FROM applicant";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("ApplicantID"),
                            rs.getString("NationalID"),
                            rs.getString("FullName"),
                            rs.getString("DateOfBirth"),
                            rs.getString("Gender"),
                            rs.getString("Address"),
                            rs.getString("Phone")
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idTxt.setText(""); nationalIdTxt.setText(""); nameTxt.setText("");
        dobTxt.setText(""); genderTxt.setText(""); addressTxt.setText("");
        phoneTxt.setText("");
    }
}