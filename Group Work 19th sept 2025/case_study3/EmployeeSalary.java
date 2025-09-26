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

public class EmployeeSalary {

	public static void main(String[] args) {
		Employee e1 = new FullTimeEmployee("Aline", 50000);
		Employee e2 = new FullTimeEmployee("John", 65000);
		Employee e3 = new PartTimeEmployee("JOSEPH", 500, 30);
		Employee e4 = new PartTimeEmployee("Eric", 300, 70);
		
		Employee[] employees = {e1,e2,e3,e4};
		
		double totalExpenditure = 0;
		
		for(Employee emp: employees){
			double salary = emp.calculateSalary();
			System.out.println(emp.getName()+ " salary: "+salary);
			
			if(salary > 60000){
				System.out.println("Higher Earner");
			}
			totalExpenditure += salary;
		}
		
		System.out.println("The total Salary Expenditure: "+ totalExpenditure);



	}

}
