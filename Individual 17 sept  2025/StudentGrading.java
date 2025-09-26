package grading;

import java.util.Scanner;

public class StudentGrading {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int totalStudents = 0;
        int passes = 0;
        int fails = 0;

        System.out.println("=== Student Grading System ===");
        System.out.println("Enter marks for each student (0–100).");
        System.out.println("Enter -1 to stop.");


        while (true) {
            System.out.print("Enter marks: ");
            int marks = kb.nextInt();

            if (marks == -1) {
                break; 
            }

            if (marks < -1 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                continue; 
            }

            totalStudents++;

           
            String grade;
            if (marks >= 80) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "B";
            } else if (marks >= 60) {
                grade = "C";
            } else if (marks >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

      
            if (marks >= 50) {
                passes++;
            } else {
                fails++;
            }

            System.out.println("Student " + totalStudents + " got grade: " + grade);
            System.out.println("-----------------------------");
        }

       
        System.out.println("\n=== CLASS SUMMARY ===");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Passed: " + passes);
        System.out.println("Failed: " + fails);

        if (totalStudents > 0) {
            double passRate = (passes * 100.0) / totalStudents;
            System.out.println("Class Pass Rate: " + passRate + "%");
        } else {
            System.out.println("No students entered.");
        }

        kb.close();
    }
}
