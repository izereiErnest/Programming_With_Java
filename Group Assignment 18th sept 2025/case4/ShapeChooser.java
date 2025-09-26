/**
 * 18th Sept 2025

 * Erneste IZERE NEZA (222001299)
 * Nicyogihe Rebeca (223011370)
 * Kangabe Belise (223007011)
 * Musemakweli Muhamed(223004968)
 * Munyarukundo Joseph (223003209)
 * Munezero Grace (223009957)
 * Ndagijimana Aloys (223017789)
 * Umwari Celine (223008405)
 **/


package com.case4;

import java.util.Scanner;

public class ShapeChooser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose a shape to calculate area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter length: ");
                double length = sc.nextDouble();

                System.out.print("Enter width: ");
                double width = sc.nextDouble();

                Rectangle rect = new Rectangle(length, width);
                System.out.println("Area of Rectangle: " + rect.calculateArea());
                break;

            case 2:
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();

                Circle circle = new Circle(radius);
                System.out.println("Area of Circle: " + circle.calculateArea());
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
