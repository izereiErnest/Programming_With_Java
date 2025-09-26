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

package case_study8;

import java.util.Scanner;

public class ATM {

    private double balance = 0;
    private final int pin = 1000; 

    
    public double checkBalance() {
        return balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful! Your new balance is: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

   
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("INSUFFICIENT BALANCE!");
        } else {
            balance -= amount;
            System.out.println("Withdraw Successful! Your new balance is: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner kd = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("Choose action to take: ");
        System.out.println("...............................");
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit ");
        System.out.println("3. Withdraw ");

        int choice = kd.nextInt();
        
        switch (choice) {

            case 1:
                System.out.println("Enter PIN: ");

                if (kd.nextInt() == atm.pin) {
                    System.out.println("Your remaining balance is: " + atm.checkBalance());
                } else {
                    System.out.println("Incorrect PIN!");
                }
                break;

            case 2:
                System.out.println("Enter PIN: ");
                if (kd.nextInt() == atm.pin) {
                    System.out.println("Enter amount to deposit: ");
                    atm.deposit(kd.nextDouble());
                } else {
                    System.out.println("Incorrect PIN!");
                }
                break;

            case 3:
                System.out.println("Enter PIN: ");
                if (kd.nextInt() == atm.pin) {
                    System.out.println("Enter amount to withdraw: ");
                    atm.withdraw(kd.nextDouble());
                } else {
                    System.out.println("Incorrect PIN!");
                }
                break;

            default:
                System.out.println("Invalid choice! Please choose between 1, 2 and 3.");
        }

        kd.close();
    }
}
