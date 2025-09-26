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

public class product {
private int productId;
private String Name;
private double price;
private int quantity;

public product(int productId, String name, double price, int quantity) {
	this.productId = productId;
	Name = name;
	this.price = price;
	this.quantity = quantity;
}

public double calculateCost(){
	return price * quantity;
}


}
