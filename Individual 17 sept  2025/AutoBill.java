package billing;

import java.util.Scanner;

public class AutoBill {

	public static void main(String[] args) {
		Scanner kd= new Scanner(System.in);
		System.out.println("How many products did you buy?");
		
		int numProd= kd.nextInt();
		int price= 0;
		kd.nextLine();
		
        String[] productNames = new String[numProd];
        int[] prices = new int[numProd];
        int[] quantities = new int[numProd];
        int[] subtotals = new int[numProd];

        int total = 0;
		
        for (int i = 0; i < numProd; i++) {
            System.out.println("\nProduct " + (i + 1) + ":");

            System.out.print("Enter item name: ");
            productNames[i] = kd.nextLine();

            System.out.print("Enter price per unit: ");
            prices[i] = kd.nextInt();

            System.out.print("Enter quantity: ");
            quantities[i] = kd.nextInt();
            kd.nextLine();

            subtotals[i] = prices[i] * quantities[i];
            total += subtotals[i];
       			
		}
		
        //Discount
        double discount = 0;
        if (total > 50000) {
            discount = total * 0.05;
        }
        double finalAmount = total - discount;

        //Receipt
        System.out.println("\n===== RECEIPT =====");
        for (int i = 0; i < numProd; i++) {
            System.out.println("Item: " + productNames[i]);
            System.out.println("   Price: " + prices[i]);
            System.out.println("   Quantity: " + quantities[i]);
            System.out.println("   Subtotal: " + subtotals[i]);
            System.out.println("------------------------------");
        }
        System.out.println("TOTAL before discount: " + total);
        System.out.println("DISCOUNT: " + discount);
        System.out.println("FINAL AMOUNT TO PAY: " + finalAmount);
        System.out.println("THANK YOU, COME AGAIN!");

        kd.close();
        
	}

}
