/**
 * 19th Sept 2025
 *
 * Erneste IZERE NEZA (222001299)
 * Nicyogihe Rebeca (223011370)
 * Kangabe Belise (223007011)
 * Musemakweli Muhamed(223004968)
 * Munyarukundo Joseph (223003209)
 * Munezero Grace (223009957)
 * Ndagijimana Aloys (223017789)
 * Umwari Celine (223008405)
 **/

package case_study4;

abstract class shape {
	private String name;
	
	public shape(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public abstract double Area();
	

}
class Circle extends shape{
	private double r;

	public Circle(String name, double r) {
		super(name);
		this.r = r;
	}


	public double Area(){
		return Math.PI * Math.pow(r, 2);
	}
	
}
class Rectangle extends shape{
	private double length;
	private double width;
	
	public Rectangle(String name,double length, double width) {
		super(name);
		this.length = length;
		this.width = width;
	}


	public double Area(){
		return length * width;
	}
}

class Triangle extends shape{
	private double base;
	private double height;
	
	public Triangle(String name,double base, double height) {
		super(name);
		this.base = base;
		this.height = height;
	}
	
	public double Area(){
		return (base * height) / 2;
	}
	
	
}
