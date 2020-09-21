package library_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// Main class for the system
public class LibrarySystem {
	
	// Main method
	public static void main(String[] args) throws IOException{
		
		// Creating the input streams and output streams along with the writers
		FileInputStream inputFile1 = new FileInputStream("input_1.txt");
		FileInputStream inputFile2 = new FileInputStream("input_2.txt");
		FileOutputStream outputFile1 = new FileOutputStream("output_1.txt");
		FileOutputStream outputFile2 = new FileOutputStream("output_2.txt");
		PrintWriter writer1 = new PrintWriter(outputFile1);
		PrintWriter writer2 = new PrintWriter(outputFile2);
		
		// Scanners for the looking through the input files
		Scanner inInput1 = new Scanner(inputFile1);
		Scanner inInput2 = new Scanner(inputFile2);
		
		// ArrayList for the first input file to hold the books and dvds
		ArrayList<LibraryBook> books1 = new ArrayList<LibraryBook>();
		ArrayList<LibraryDVD> dvds1 = new ArrayList<LibraryDVD>();
		
		// ArrayList for the second input file to hold the books and dvds
		ArrayList<LibraryBook> books2 = new ArrayList<LibraryBook>();
		ArrayList<LibraryDVD> dvds2 = new ArrayList<LibraryDVD>();
		
		// Some output to the console to let the user know the system is reading through the values
		System.out.println("Reading through the first input file...");
		
		// Loop for the first input file
		while (inInput1.hasNext()) {
			
			// Variable for holding the value of what to do with the information
			String action = inInput1.next();
			
			// Check to see if the action variable is for a new book or dvd
			if (action.equalsIgnoreCase("new")) {
				
				// Variable for holding whether its a book or a dvd
				String type = inInput1.next();
				
				// Check to see if its a book or dvd
				if (type.equalsIgnoreCase("book")) {
					
					// Creating a new book item and setting its variables with the correct read values
					LibraryBook book = new LibraryBook();
					book.setISBNNumber(inInput1.next());
					book.setBookTitle(inInput1.nextLine());
					books1.add(book);
					
				} else {
					
					// Creating a new dvd item and setting its variables with the correct read values
					LibraryDVD dvd = new LibraryDVD();
					dvd.setTrackNum(inInput1.nextLong());
					dvd.setYear(inInput1.nextLong());
					dvd.setTitle(inInput1.nextLine());
					dvds1.add(dvd);
					
				}
			
				// Check to see if the action is for a checkout
			} else if (action.equalsIgnoreCase("checkout")) {
				
				// Variable for holding the type of book or dvd
				String type = inInput1.next();
				
				// Check to see if the type is a book
				if (type.equalsIgnoreCase("book")) {
					
					// Variable to hold the ISBN value
					String isbn = inInput1.next();
					
					// For loop to look through the books array list
					for (LibraryBook book : books1) {
						
						// Assigning the iterated books isbn to this variable
						String bookISBN = book.getISBN();
						
						// Check to see if the iterated books is the same as the read value
						if (bookISBN.equalsIgnoreCase(isbn)) {
							
							// Setting the value of the specified books checkout status
							book.checkOut();
							break;
							
						}
						
					}
					
					// Part of the check if its not a book and its a dvd
				} else {
					
					// Setting the variable of the dvds track number
					long trackNum = inInput1.nextLong();
					
					// For loop to look through the dvds array list
					for (LibraryDVD dvd : dvds1) {
						
						// Variable for holding the read for the dvds track number
						long dvdTrackNum = dvd.getTrackNum();
						
						// Check to see if the iterated dvds is the same as the read value
						if (dvdTrackNum == trackNum) {
							
							// Setting the value of the specified dvds checkout status
							dvd.checkOut();
							break;
							
						}
						
					}
					
				}
				
				// Check to see if the action is for returning
			} else if ( action.equalsIgnoreCase("return")) {
				
				// Variable for holding the read value of the type
				String type = inInput1.next();
				
				// Check to see if the type is a book or a dvd
				if (type.equalsIgnoreCase("book")) {
					
					// Variable to hold the isbn of the book
					String isbn = inInput1.next();
					
					// For loop to iterate through the books array list
					for (LibraryBook book : books1) {
						
						// Variable to hold the value of the iterated books ISBN
						String bookISBN = book.getISBN();
						
						// Check to see if the iterated books value is the same as the read value
						if (bookISBN.equalsIgnoreCase(isbn)) {
							
							// Setting the value of the specified books checkin status
							book.checkIn();
							break;
							
						}
						
					}
					
				} else {
					
					// Variable to hold the dvds track number
					long trackNum = inInput1.nextLong();
					
					// For loop iterating through the dvds array list
					for (LibraryDVD dvd : dvds1) {
						
						// Variable to hold the iterated dvds track number
						long dvdTrackNum = dvd.getTrackNum();
						
						// Check to see if the iterated dvds track number is the same as the read value
						if (dvdTrackNum == trackNum) {
							
							// Setting the value of the specified books checkin status
							dvd.checkIn();
							break;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		// Some output to the console to let the user now the system has finished reading the values
		System.out.println("Finished reading through the first file!!");
		
		// Print some formatting to the output file
		writer1.println("Library Books");
		writer1.println();
		
		// For loop to itterate through the arraylist of books
		for (LibraryBook book : books1) {
			
			// Putting the item into the print statement allows for the overridden toString() method
			// to print the specified output from the class
			writer1.println(book);
			writer1.println();
			
		}
		
		// Printing some more formatting into the output file
		writer1.println("Library DVDs");
		writer1.println();
		
		// For loop to itterate through the arraylist of dvds
		for (LibraryDVD dvd : dvds1) {
			
			writer1.println(dvd);
			writer1.println();
			
		}
		
		// Output to the console to let the user know its started reading through the second inputs values
		System.out.println("Reading through the second input file...");
		
		// The code below is basically all the same as the above except for the arraylist
		// and which file the system is reading through
		while (inInput2.hasNext()) {
			
			String action = inInput2.next();
			
			if (action.equalsIgnoreCase("new")) {
				
				String type = inInput2.next();
				
				if (type.equalsIgnoreCase("book")) {
					
					LibraryBook book = new LibraryBook();
					book.setISBNNumber(inInput2.next());
					book.setBookTitle(inInput2.nextLine());
					books2.add(book);
					
				} else {
					
					LibraryDVD dvd = new LibraryDVD();
					dvd.setTrackNum(inInput2.nextLong());
					dvd.setYear(inInput2.nextLong());
					dvd.setTitle(inInput2.nextLine());
					dvds2.add(dvd);
					
				}
				
			} else if (action.equalsIgnoreCase("checkout")) {
				
				String type = inInput2.next();
				
				if (type.equalsIgnoreCase("book")) {
					
					String isbn = inInput2.next();
					
					for (LibraryBook book : books2) {
						
						String bookISBN = book.getISBN();
						
						if (bookISBN.equalsIgnoreCase(isbn)) {
							
							book.checkOut();
							break;
							
						}
						
					}
					
				} else {
					
					long trackNum = inInput2.nextLong();
					
					for (LibraryDVD dvd : dvds2) {
						
						long dvdTrackNum = dvd.getTrackNum();
						
						if (dvdTrackNum == trackNum) {
							
							dvd.checkOut();
							break;
							
						}
						
					}
					
				}
				
			} else if (action.equalsIgnoreCase("return")) {
				
				String type = inInput2.next();
				
				if (type.equalsIgnoreCase("book")) {
					
					String isbn = inInput2.next();
					
					for (LibraryBook book : books2) {
						
						String bookISBN = book.getISBN();
						
						if (bookISBN.equalsIgnoreCase(isbn)) {
							
							book.checkIn();
							break;
							
						}
						
					}
					
				} else {
					
					long trackNum = inInput2.nextLong();
					
					for (LibraryDVD dvd : dvds2) {
						
						long dvdTrackNum = dvd.getTrackNum();
						
						if (dvdTrackNum == trackNum) {
							
							dvd.checkIn();
							break;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		// Output to the user that it has finished reading through all the input values
		System.out.println("Finished reading through the second file!!");
		
		// Printing some formatting to the output file
		writer2.println("Library Books");
		writer2.println();
		
		// For looping iterating throught he array list and printing the book information
		for (LibraryBook book : books2) {
			
			writer2.println(book);
			writer2.println();
			
		}
		
		
		// Printing some formatting to the output file
		writer2.println("Library DVDs");
		writer2.println();
		
		// For looping iterating throught he array list and printing the dvd information
		for (LibraryDVD dvd : dvds2) {
			
			writer2.println(dvd);
			writer2.println();
			
		}
		
		// Printing to the console some information about the book arraylists
		System.out.println("Number of books for first input: " + books1.size());
		System.out.println("Number of books for second input: " + books2.size());
		
		// Some variables initilized with some default values
		int count1 = 0, count2 = 0, count3 = 0,count4 = 0;
		
		// For loop to itterate through the array list to get the status of the books to add it to a count for output later
		for (LibraryBook book : books1) {
			
			// Variable to hold the status
			boolean status = book.getBookStatus();
			
			// Check to see if the status is true
			if (status == true) {
				
				count1++;
				
			}
			
		}
		
		// Printing to the console some information about the book arraylists
		System.out.println("Number of books that are checked out in first input: " + count1);
		
		
		// For loop to itterate through the array list to get the status of the books to add it to a count for output later
		for (LibraryBook book : books2) {
			
			// Variable to hold the status
			boolean status = book.getBookStatus();
			
			// Check to see if the status is true
			if (status == true) {
				
				count2++;
				
			}
			
		}
		
		// Printing to the console some information about the book arraylists
		System.out.println("Number of books that are checked out in second input: " + count2);
		System.out.println("Number of dvds for first input: " + dvds1.size());
		System.out.println("Number of dvds for second input: " + dvds2.size());
		
		// For loop to itterate through the array list to get the status of the books to add it to a count for output later
		for (LibraryDVD dvd : dvds1) {
			
			// Variable to hold the status
			boolean status = dvd.getDVDStatus();
			
			// Check to see if the status is true
			if (status == true) {
				
				count3++;
				
			}
			
		}
		
		// Printing to the console some information about the book arraylists
		System.out.println("Number of dvds that are checked out in first input: " + count3);
		
		// For loop to itterate through the array list to get the status of the books to add it to a count for output later
		for (LibraryDVD dvd : dvds2) {
			
			// Variable to hold the status
			boolean status = dvd.getDVDStatus();
			
			// Check to see if the status is true
			if (status == true) {
				
				count4++;
				
			}
			
		}
		
		
		// Printing to the console some information about the book arraylists
		System.out.println("Number of dvds that are checked out in second input: " + count4);
		
		// Closing the inputs and print writers
		inInput2.close();
		inInput1.close();
		writer2.close();
		writer1.close();
		
	}

}
