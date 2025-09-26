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

public class Circle {
    private double radius;
    double pi = 3.141592653589793;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return pi * (radius * radius);
    }
}
