package classattendance;

import java.util.Scanner;

public class Iattend {

    public static void main(String[] args) {
        Scanner kd = new Scanner(System.in);

        int semesterSize = 30;
        int[] attendance = new int[semesterSize];
        int days = 0; 

        
        System.out.print("Enter total number of students in class: ");
        int classSize = kd.nextInt();

        char choice;
        do {
            System.out.print("Enter number of students present on Day " + (days + 1) + ": ");
            attendance[days] = kd.nextInt();
            days++;

            System.out.print("Do you want to add another day? (yes/no): ");
            choice = kd.next().charAt(0);
        } while(choice == 'y' || choice == 'Y');;

       
        System.out.println("\n=== SEMESTER SUMMARY ===");
        int totalPresent = 0;
        int lowAttendanceDays = 0;

        for (int i = 0; i < days; i++) {
            System.out.println("Day " + (i + 1) + ": " + attendance[i] + " present");
            totalPresent += attendance[i];

            if (attendance[i] < (classSize / 2)) {
                lowAttendanceDays++;
            }
        }

      
        double averageAttendance = (days > 0) ? (totalPresent * 1.0 / days) : 0;
        double lowAttendancePercent = (days > 0) ? (lowAttendanceDays * 100.0 / days) : 0;

        System.out.println("-----------------------------");
        System.out.println("Average attendance: " + averageAttendance);
        System.out.println("Days with less than 50% attendance: " + lowAttendanceDays);
        System.out.println("Percentage of low attendance days: " + lowAttendancePercent + "%");

        kd.close();
    }
}
