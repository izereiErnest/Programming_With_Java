package case_study7;

public class Vehicle {
 String registration;
 int speed;

public Vehicle(String registration, int speed) {
	super();
	this.registration = registration;
	this.speed = speed;
}
public void displayDetails(){
	System.out.println("Registetion: "+registration);
	System.out.println("Speed: "+speed+" km/h");
}
}
class Car extends Vehicle {
	private double fuelEfficiency;

	public Car(String registrstion, int speed, double fuelEfficiency) {
		super(registrstion, speed);
		this.fuelEfficiency = fuelEfficiency;
	}
	@Override
	public void displayDetails(){
		System.out.println("Car Detalis:");
		super.displayDetails();
		System.out.println("Fuel Efficiency: "+ fuelEfficiency+ "km/l");

	}
}
class Bike extends Vehicle{
	private double fuelEfficiency;

	public Bike(String registrstion, int speed, double fuelEfficiency) {
		super(registrstion, speed);
		this.fuelEfficiency = fuelEfficiency;
	}
	@Override
	public void displayDetails(){
		System.out.println("Bike Detalis:");
		super.displayDetails();
		System.out.println("Fuel Efficiency: "+ fuelEfficiency+ "km/l");

	}
	
}
class Trunk extends Vehicle{
	private double loadCapacity;

	public Trunk(String registrstion, int speed, double loadCapacity) {
		super(registrstion, speed);
		this.loadCapacity = loadCapacity;
	}
	
	@Override
	public void displayDetails(){
		System.out.println("Truck Detalis:");
		super.displayDetails();
		System.out.println("load Capacity: "+loadCapacity + "Tones");

	}
	
}
