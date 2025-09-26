package com.form;

import com.panel.*;

import javax.swing.*;
import java.awt.*;

public class IAPS extends JFrame {
    JTabbedPane tabs = new JTabbedPane();

    public IAPS(String role, int userid) {
        setTitle("Immigration Passport System - " + role);
        setSize(1000, 700);
        setLayout(new BorderLayout());

        if(role.equalsIgnoreCase("admin")){
            tabs.add("Users", new UserPanel());
            tabs.add("Roles", new RolePanel());
            tabs.add("Applicants", new ApplicantPanel());
            tabs.add("Passport Types", new PassportTypePanel());
            tabs.add("Applications", new ApplicationPanel());
            tabs.add("Passports", new PassportPanel());
        }else if(role.equalsIgnoreCase("officer")){
            tabs.add("Applicants", new ApplicantPanel());
            tabs.add("Applications", new ApplicationPanel());
        }else if(role.equalsIgnoreCase("applicant")){
            tabs.add("My Applications", new ApplicationPanel());
        }

        add(tabs, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}