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


package com.case1;

import java.util.Scanner;

public class Rectangle {
    private double length;
    private double width;

    
    public double calculateArea() {
        return length * width;
    }

    
    public static void main(String[] args) {
        Scanner rect = new Scanner(System.in);

        Rectangle r = new Rectangle();

        System.out.print("Enter Length: ");
        r.length = rect.nextDouble();

        System.out.print("Enter Width: ");
        r.width = rect.nextDouble();

        double area = r.calculateArea();
        System.out.println("Area: " + area);

        if (r.length == r.width) {
            System.out.println("This is a Square");
        } else {
            System.out.println("This is a Rectangle");
        }

        rect.close();
    }
}
