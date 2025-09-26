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

package case_study2;

public class StudentGrade {

	public static void main(String[] args) {
		Student st1 = new Student(01,"Joseph MUNYARUKUNDO", new double[]{70,75.5,60});
		Student st2 = new Student(02,"Ketia MUTAKO", new double[]{89,80,50});
		
		Student[] student = {st1,st2};
		
		for(Student s : student){
			System.out.println("Student: "+ s.getName());
			System.out.println("Average marks: "+ s.getAverage());
			System.out.println("Grade:"+ s.getGrade());
			System.out.println();
		}

		double highestAverage = student[0].getAverage();
        for (int i = 1; i < student.length; i++) {
            if (student[i].getAverage() > highestAverage) {
                highestAverage = student[i].getAverage();
            }
        }
        System.out.println("Highest Average Marks: " + highestAverage);
	}

}
