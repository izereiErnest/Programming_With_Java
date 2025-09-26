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

public class LibaryManagment {

	public static void main(String[] args) {
		Book b1 = new Book("To Kill a Mockingbird","Harper Lee");
		Book b2 = new Book("The Alchemist","Paulo Coelho");
		Book b3 = new Book("The Great Gatsby","F. Scott Fitzgerald");
		/**
		b1.borrow();
		b2.borrow();
		b2.borrow();
		
		b2.returnedBook();
		b2.borrow();
		**/
		Book[] library = {b1,b2,b3};
		System.out.println("\nAvailable Books are :");
		for(Book book:library){
			book.display();
		}
		

	}

}
