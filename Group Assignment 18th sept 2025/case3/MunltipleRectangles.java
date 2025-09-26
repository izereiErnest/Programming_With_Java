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


package com.case3;

import java.util.Scanner;

public class MunltipleRectangles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Three_triangle[] rectangles = new Three_triangle[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter length for rectangle " + (i + 1) + ":");
            double length = scanner.nextDouble();

            System.out.println("Enter width for rectangle " + (i + 1) + ":");
            double width = scanner.nextDouble();

            rectangles[i] = new Three_triangle(length,width);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Area of rectangle " + (i + 1) + ": " + rectangles[i].calculateArea());
        }

        scanner.close();


	}

}
