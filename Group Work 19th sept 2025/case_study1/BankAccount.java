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

public class BankAccount {
	private String account_number;
	private String holderName;
	private  double balance;

	public BankAccount(String account_number, String holderName, double balance) {
		super();
		this.account_number = account_number;
		this.holderName = holderName;
		this.balance = balance;
	}
	public void deposite(double amount){
		balance += amount;
		System.out.println(amount + " deposited. New balance: "+ balance);
	}

	public void withdraw(double amount){
		if(amount > balance){
			System.out.println("Insufficient Funds");
		}
		else{
			balance -= amount;
			System.out.println(amount + " withdrawn. New balance: "+ balance);
		}
		if(balance < 1000){
			System.out.println("Low Balance");
		}
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void displayAccount(){
		System.out.println("Account number is: "+ account_number);
		System.out.println("Holder's Name is: "+ holderName);
		System.out.println("Balance is: "+balance);

	}


}
