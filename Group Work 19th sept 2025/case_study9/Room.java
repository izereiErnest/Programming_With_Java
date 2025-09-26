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

package case_study9;

import java.util.Scanner;

public class Room {
	
	private int roomNbr;
	private String type;
	private double pricePernight;

	public Room(int roomNbr, String type, double pricePernight) {
		this.roomNbr=roomNbr;
		this.type=type;
		this.pricePernight=pricePernight;
	}

	public int getRoomNbr() {
		return roomNbr;
	}

	public void setRoomNbr(int roomNbr) {
		this.roomNbr = roomNbr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPricePernight() {
		return pricePernight;
	}

	public void setPricePernight(double pricePernight) {
		this.pricePernight = pricePernight;
	}
	
	public double calcPrice(int nights) {
		double total = nights*pricePernight;
		
		if (nights > 5) {
			total = total - (total*0.15);
		}
		return total;
	}

    public static void main(String[] args) {
    	Scanner kd=new Scanner(System.in);

        Room standard = new Room(101, "Standard", 50.0);
        Room deluxe = new Room(201, "Deluxe", 100.0);
        Room suite = new Room(301, "Suite", 200.0);
        
        System.out.println("Choose the room type: ");
        System.out.println(".............................");
        System.out.println("1. Standard");
        System.out.println("2. Deluxe");
        System.out.println("3. Suite");
        
        int choice=kd.nextInt();
        
        System.out.println("Enter number of nights: ");
        int nightsStayed = kd.nextInt();
               

        switch(choice) {
        case 1:
        	double totalBill = standard.calcPrice(nightsStayed);
            System.out.println("Room Type: " + standard.getType());
            System.out.println("Nights Stayed: " + nightsStayed);
            System.out.println("Total Bill: $" + totalBill);    
        break;
        
        case 2:
        	double totalBill2 = deluxe.calcPrice(nightsStayed);
            System.out.println("Room Type: " + deluxe.getType());
            System.out.println("Nights Stayed: " + nightsStayed);
            System.out.println("Total Bill: $" + totalBill2);
            
        case 3:
        	double totalBill3 = suite.calcPrice(nightsStayed);
            System.out.println("Room Type: " + suite.getType());
            System.out.println("Nights Stayed: " + nightsStayed);
            System.out.println("Total Bill: $" + totalBill3);
        
        }   
        
    }
}
