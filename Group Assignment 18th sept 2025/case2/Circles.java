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


package com.case2;

import java.util.Scanner;

public class Circles {	
	private double radius;
	double pi = 3.141592653589793;
	
	public double calculateArea() {
		return (radius*radius)*pi;
	}
	public double calculateCircumference() {
		return (radius*2)*pi;
	}

	public static void main(String[] args) {
		Scanner cir = new Scanner(System.in);
		
		Circles c = new Circles();		
		
		
		System.out.println("Enter Radius: ");
		c.radius = cir.nextDouble();

		System.out.println("Click 1 for Area or 2 for circumference: ");
		
		int selection = cir.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("The area of your Circle is: "+c.calculateArea());
			break;
		case 2:
			System.out.println("The circumference of your Circle is: "+c.calculateCircumference());
			break;
		default:
			System.out.println("Invalid input! please select between 1 and 2");
		}	
	cir.close();			

	}

}
