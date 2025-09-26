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

package case_study1;

public class BankManagment {

	public static void main(String[] args) {
	
		BankAccount acount1 = new BankAccount("001","Joseph",0);
		BankAccount acount2 = new BankAccount("002","Munyana",0);
		
		acount1.deposite(5000);
		
		acount1.withdraw(2000);
		
		acount2.withdraw(2000);
		
		System.out.println("\n First Account Display");
		acount1.displayAccount();
		
		System.out.println("\n Second Account Display");
		acount2.displayAccount();

		


	}

}
