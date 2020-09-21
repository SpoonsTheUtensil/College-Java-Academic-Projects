package library_system;

// Library Book Class
public class LibraryBook {
	
	// Creating some variables with some default values
	String book_Title, isbn_Number;
	boolean isCheckedOut = false;
	
	// Default constructor without variable inits
	public LibraryBook() {
		
		book_Title = "";
		isbn_Number = "";
		
	}
	
	// Another constructor for creating the object with some values passed
	public LibraryBook(String isbn, String title, boolean bookStatus) {
		
		isbn_Number = isbn;
		book_Title = title;
		isCheckedOut = bookStatus;
		
	}
	
	// Setter method for the books title
	public void setBookTitle(String title) {
		
		book_Title = title;
		
	}
	
	// Setter method for the isbn number of the book
	public void setISBNNumber(String isbnValue) {
		
		isbn_Number = isbnValue;
		
	}
	
	// Setter method for the status of the book being checked out or not
	public void setBookStatus(boolean status) {
		
		isCheckedOut = status;
		
	}
	
	// Getter method for the books title
	public String getBookTitle() {
		
		return book_Title;
		
	}
	
	// Getter method for the isbn number of the book
	public String getISBN() {
		
		return isbn_Number;
	}
	
	// Getter method for the status of the book being checked out or not
	public boolean getBookStatus() {
		
		return isCheckedOut;
		
	}
	
	// Method to change the value of the books status
	public void checkOut() {
		
		setBookStatus(true);
		
	}
	
	// Method to change the value of the books status
	public void checkIn() {
		
		setBookStatus(false);
		
	}
	
	// Overriding the toString method for this class to print the title and ISBN
	public String toString() {
		
		return "Title: " + getBookTitle().trim() + "\n"
				+ "ISBN: " + getISBN();
		
	}

}
