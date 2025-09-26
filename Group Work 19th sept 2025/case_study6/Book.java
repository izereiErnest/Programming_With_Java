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

package case_study6;

public class Book {
private String title;
private String author;
private boolean available;

public Book(String title, String author) {
	super();
	this.title = title;
	this.author = author;
	this.available = available;
}

public boolean borrow(){
	if(available){
		available = false;
		System.out.println("You have succesfull Borrowed: "+ title+ " Book.");
		return true;
	}
	else {
		System.out.println("Sorry the book of: "+ title+ " is current not available.");
	}
	return false;
}
public void returnedBook(){
	available = true;
	System.out.println("You have succesfull returned: "+ title+ " Book.");

}
public void display(){
	if(available){
		System.out.println("Available books: "+ title+ " by "+ author);
	}
}
}
