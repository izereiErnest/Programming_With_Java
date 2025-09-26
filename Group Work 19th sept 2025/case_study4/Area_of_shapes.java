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

public class Area_of_shapes {

	public static void main(String[] args) {
		shape sh1 = new Circle("Cirle",4);
		shape sh2 = new Rectangle("Rectangle",23,13);
		shape sh3 = new Triangle("Triangle",4,3);
		
		shape[] shapes = {sh1,sh2,sh3};
		
		for(shape sh: shapes){
			System.out.println(sh.getName()+" Area: "+sh.Area());
		}

	}

}
