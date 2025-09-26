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


package com.case5;

import java.util.Scanner;

public class CompareShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rectangle input
        System.out.print("Enter length of Rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter width of Rectangle: ");
        double width = sc.nextDouble();

        Rectangle rect = new Rectangle(length, width);
        double rectArea = rect.calculateArea();

        // Circle input
        System.out.print("Enter radius of Circle: ");
        double radius = sc.nextDouble();

        Circle circle = new Circle(radius);
        double circleArea = circle.calculateArea();

        // Compare areas
        System.out.println("Area of Rectangle: " + rectArea);
        System.out.println("Area of Circle: " + circleArea);

        if (rectArea > circleArea) {
            System.out.println("Rectangle has a larger area.");
        } else if (circleArea > rectArea) {
            System.out.println("Circle has a larger area.");
        } else {
            System.out.println("Both shapes have the same area.");
        }

        sc.close();
    }
}
