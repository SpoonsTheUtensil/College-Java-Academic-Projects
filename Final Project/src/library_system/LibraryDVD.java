package library_system;

// Library DVD Class
public class LibraryDVD {
	
	// Creating some variables with some default values
	long track_Number, year;
	String dvd_Title;
	boolean isCheckedOut = false;
	
	// Default constructor without variable inits
	public LibraryDVD() {
		
		track_Number = -1;
		dvd_Title = "";
		year = 1970;
		
	}
	
	// Another constructor for creating the object with some values passed
	public LibraryDVD(long track_Num, long y, String title, boolean bookStatus) {
		
		track_Number = track_Num;
		year = y;
		dvd_Title = title;
		isCheckedOut = bookStatus;
		
	}
	
	// Setter method for the dvds track number
	public void setTrackNum(long num) {
		
		track_Number = num;
		
	}
	
	// Setter method for the dvds year
	public void setYear(long y) {
		
		year = y;
		
	}
	
	// Setter method for the dvds title
	public void setTitle(String title) {
		
		dvd_Title = title;
		
	}
	
	// Setter method for the status of the dvd being checked out or not
	public void setDVDStatus(boolean status) {
		
		isCheckedOut = status;
		
	}
	
	// Getter method for the dvds track number
	public long getTrackNum() {
		
		return track_Number;
		
	}
	
	// Getter method for the dvds year
	public long getYear() {
		
		return year;
		
	}
	
	// Getter method for the dvds title
	public String getDVDTitle() {
		
		return dvd_Title;
		
	}
	
	// Getter method for the status of the dvd being checked out or not
	public boolean getDVDStatus() {
		
		return isCheckedOut;
		
	}
	
	// Method to change the value of the dvds status
	public void checkOut() {
		
		setDVDStatus(true);
		
	}
	
	// Method to change the value of the dvds status
	public void checkIn() {
		
		setDVDStatus(false);
		
	}
	
	// Overriding the toString method for this class to print the title, year and track number
	public String toString() {
		
		return "Title: " + getDVDTitle().trim() + "\n"
				+ "Year: " + getYear() + "\n"
				+ "Track Number: " + getTrackNum();
		
	}

}
