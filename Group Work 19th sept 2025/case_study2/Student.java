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


public class Student {
	private int id;
	private String name;
	private double[] marks = new double[3];
	




	public Student(int id, String name, double[] marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}



	public double calculateAverage(){
		int sum = 0;
		for(double mark:marks){
			sum += mark;
		}
		return (double) sum / marks.length;
	}
	public char getGrade(){
		double Average = calculateAverage();
		if(Average >= 80){
			return 'A';
		}
		else if(Average >= 60){
			return 'B';
		}
		else if(Average >= 40){
			return 'C';
		}
		else{
			return 'F';
		}
	}



	public String getName() {
		return name;
	}



	public double getAverage() {
		return calculateAverage();
	}
	
	
	

}
