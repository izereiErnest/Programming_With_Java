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

package case_study5;

public class ShoppingCart {

	public static void main(String[] args) {
		product[] products = {
				new product(01,"Laptop",40000,1),
				new product(02,"Mouse",1000,2),
				new product(03,"Keyboard",3000,1),};
		double totalBill = 0;
		for(product p:products){
			totalBill += p.calculateCost();
		}
		boolean discountApplied = false;
		if(totalBill > 10000){
			totalBill = totalBill * 0.9;
			discountApplied = true;
		}
		System.out.println("Total bill: "+ totalBill);
		if(discountApplied){
			System.out.println("Discount Applied");
		}
		else{
			System.out.println("Discount not Applied");
		}

	}

}
