package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PassportPanel extends JPanel implements ActionListener {
    JTextField passportIdTxt = new JTextField(), appIdTxt = new JTextField(),
            numberTxt = new JTextField(), issueDateTxt = new JTextField(),
            expiryDateTxt = new JTextField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"),
            deletebtn = new JButton("Delete"), loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    public PassportPanel() {
        setLayout(null);
        String[] labels = {"PassportID", "ApplicationID", "PassportNumber", "IssueDate", "ExpiryDate"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 150, 900, 400);

        int y = 20;
        addField("PassportID", passportIdTxt, y);
        y = 50;
        addField("ApplicationID", appIdTxt, y);
        y = 80;
        addField("PassportNumber", numberTxt, y);
        y = 110;
        addField("IssueDate", issueDateTxt, y);
        y = 140;
        addField("ExpiryDate", expiryDateTxt, y);

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
        l.setBounds(20, y, 120, 25);
        txt.setBounds(140, y, 150, 25);
        add(l); add(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()) {
            if (e.getSource() == addbtn) {
                String sql = "INSERT INTO passport (ApplicationID, PassportNumber, IssueDate, ExpiryDate) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(appIdTxt.getText()));
                ps.setString(2, numberTxt.getText());
                ps.setString(3, issueDateTxt.getText());
                ps.setString(4, expiryDateTxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passport added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                String sql = "UPDATE passport SET ApplicationID=?, PassportNumber=?, IssueDate=?, ExpiryDate=? WHERE PassportID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(appIdTxt.getText()));
                ps.setString(2, numberTxt.getText());
                ps.setString(3, issueDateTxt.getText());
                ps.setString(4, expiryDateTxt.getText());
                ps.setInt(5, Integer.parseInt(passportIdTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passport updated successfully!");
                clearFields();

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM passport WHERE PassportID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(passportIdTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passport deleted successfully!");
                clearFields();

            } else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                String sql = "SELECT * FROM passport";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("PassportID"),
                            rs.getInt("ApplicationID"),
                            rs.getString("PassportNumber"),
                            rs.getString("IssueDate"),
                            rs.getString("ExpiryDate")
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        passportIdTxt.setText(""); appIdTxt.setText(""); numberTxt.setText("");
        issueDateTxt.setText(""); expiryDateTxt.setText("");
    }
}