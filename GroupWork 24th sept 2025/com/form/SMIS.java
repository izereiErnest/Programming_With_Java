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

import com.panel.TeacherPanel;
import com.panel.UserPanel;

import javax.swing.*;
import java.awt.*;
import com.panel.*;

public class SMIS extends JFrame {
    JTabbedPane tabs = new JTabbedPane();
    //constructor

    public SMIS(String role, int userid) {
        setTitle("School Management System");
        setSize(900, 600);
        setLayout(new BorderLayout());
        if(role.equalsIgnoreCase("admin")){
            tabs.add("Users", new UserPanel());
            tabs.add("Teachers", new TeacherPanel());
            tabs.add("Courses", new CoursePanel());
            tabs.add("Students", new StudentPanel());
            tabs.add("Marks", new MarkPanel());
        }else if(role.equalsIgnoreCase("teacher")){
            tabs.add("Courses", new CoursePanel());
            tabs.add("Marks", new MarkPanel());
        }else if(role.equalsIgnoreCase("student")){
            tabs.add("My Marks", new MarkPanel());
        }
        add(tabs, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
