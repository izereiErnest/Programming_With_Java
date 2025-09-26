package com.panel;

import com.utils.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ApplicationPanel extends JPanel implements ActionListener {
    JTextField appIdTxt = new JTextField(), applicantIdTxt = new JTextField(), userIdTxt = new JTextField(),
            typeIdTxt = new JTextField(), dateTxt = new JTextField(), statusTxt = new JTextField(),
            notesTxt = new JTextField();
    JButton addbtn = new JButton("Add"), updatebtn = new JButton("Update"),
            deletebtn = new JButton("Delete"), loadbtn = new JButton("Load");
    JTable table;
    DefaultTableModel model;

    public ApplicationPanel() {
        setLayout(null);
        String[] labels = {"ApplicationID", "ApplicantID", "UserID", "PassportTypeID", "SubmissionDate", "CurrentStatus", "Notes"};
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 900, 400);

        int y = 20;
        addField("ApplicationID", appIdTxt, y);
        y = 50;
        addField("ApplicantID", applicantIdTxt, y);
        y = 80;
        addField("UserID", userIdTxt, y);
        y = 110;
        addField("PassportTypeID", typeIdTxt, y);
        y = 140;
        addField("SubmissionDate", dateTxt, y);
        y = 170;
        addField("Status", statusTxt, y);
        y = 200;
        addField("Notes", notesTxt, y);

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
        l.setBounds(20, y, 120, 25);
        txt.setBounds(140, y, 150, 25);
        add(l); add(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()) {
            if (e.getSource() == addbtn) {
                String sql = "INSERT INTO application (ApplicantID, UserID, PassportTypeID, SubmissionDate, CurrentStatus, Notes) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(applicantIdTxt.getText()));
                ps.setInt(2, Integer.parseInt(userIdTxt.getText()));
                ps.setInt(3, Integer.parseInt(typeIdTxt.getText()));
                ps.setString(4, dateTxt.getText());
                ps.setString(5, statusTxt.getText());
                ps.setString(6, notesTxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Application added successfully!");
                clearFields();

            } else if (e.getSource() == updatebtn) {
                String sql = "UPDATE application SET ApplicantID=?, UserID=?, PassportTypeID=?, SubmissionDate=?, CurrentStatus=?, Notes=? WHERE ApplicationID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(applicantIdTxt.getText()));
                ps.setInt(2, Integer.parseInt(userIdTxt.getText()));
                ps.setInt(3, Integer.parseInt(typeIdTxt.getText()));
                ps.setString(4, dateTxt.getText());
                ps.setString(5, statusTxt.getText());
                ps.setString(6, notesTxt.getText());
                ps.setInt(7, Integer.parseInt(appIdTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Application updated successfully!");
                clearFields();

            } else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM application WHERE ApplicationID=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(appIdTxt.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Application deleted successfully!");
                clearFields();

            } else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                String sql = "SELECT * FROM application";
                ResultSet rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("ApplicationID"),
                            rs.getInt("ApplicantID"),
                            rs.getInt("UserID"),
                            rs.getInt("PassportTypeID"),
                            rs.getString("SubmissionDate"),
                            rs.getString("CurrentStatus"),
                            rs.getString("Notes")
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        appIdTxt.setText(""); applicantIdTxt.setText(""); userIdTxt.setText("");
        typeIdTxt.setText(""); dateTxt.setText(""); statusTxt.setText("");
        notesTxt.setText("");
    }
}