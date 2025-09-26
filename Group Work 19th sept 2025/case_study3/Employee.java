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

package case_study3;

 abstract class Employee {
	private String name;

	public Employee(String name) {
		
		this.name = name;
	}
	public abstract double calculateSalary();
	
	public String getName() {
		return name;
	}}
	
class FullTimeEmployee extends Employee{
	private double baseSalary;

	public FullTimeEmployee(String name, double baseSalary) {
		super(name);
		this.baseSalary = baseSalary;
	}
	public double  calculateSalary(){
		return baseSalary + (0.2 + baseSalary);
	}

	
	
	
}
class PartTimeEmployee extends Employee{
	private double hourlyRate;
	private double hoursWorked;
	
	public PartTimeEmployee(String name, double hourlyRate, double hoursWorked) {
		super(name);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}
	
	public double calculateSalary(){
		return hourlyRate * hoursWorked;
	}
	}
		

