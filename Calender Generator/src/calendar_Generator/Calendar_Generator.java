package calendar_Generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calendar_Generator {

	public static void main(String[] args) {
		
		
		// Creating some variables needed throughout
		long year, leapYearChk1, leapYearChk2, leapYearChk3;
		int month, monthLength, amtSpaces, dayOfFirst, febDays;
		String day, monthName, monthHeader, monthHeaderFormat = "";
		final String DAY_NAMES = "Sun Mon Tue Wed Thu Fri Sat";
		final int CALENDER_SIZE = 27;
		boolean isLeapYear;
		
		// During some independent learning and research I came across this data
		// data structure and thought it was better then my original solution
		// to handle the days of the week which in turn made however many lines
		// I had cut in half pretty much
		Map<String, Integer> daysOfWeek = new HashMap<String, Integer>();
		daysOfWeek.put("sun", 1);
		daysOfWeek.put("mon", 2);
		daysOfWeek.put("tue", 3);
		daysOfWeek.put("wed", 4);
		daysOfWeek.put("thu", 5);
		daysOfWeek.put("fri", 6);
		daysOfWeek.put("sat", 7);
		
		// Creating the scanner and assigning it to the correct variable
		Scanner input = new Scanner(System.in);
		
		// Getting the input for the year needed from the user
		// and assigning it to the correct variable
		System.out.print("What is the year? ");
		year = input.nextLong();
		
		// Getting the input for the month needed from the user
		// and assigning it to the correct variable
		System.out.print("What month is it? ");
		month = input.nextInt();
		
		// Getting the input for the year needed from the user
		// and assigning it to the correct variable and then
		// changing whatever input it was to lower-case for easier
		// use throughout the program
		System.out.print("What day of the week is the 1st of the month? ");
		day = input.next();
		day = day.toLowerCase();

		// Closing the scanner because we no longer need to get anymore input
		input.close();
		
		// Doing the calculation for the leap year problem
		// and assigning it to a variable
		leapYearChk1 = year % 4;
		leapYearChk2 = year % 100;
		leapYearChk3 = year % 400;
		
		// Checking each calculation and determining if the year
		// given by the user is a leap year or not
		// and giving the appropriate return to the boolean isLeapYear
		if (leapYearChk1 == 0) {
			isLeapYear = true;
		}
		else if (leapYearChk2 == 0 && leapYearChk3 != 0) {
			isLeapYear = true;
		}
		else {
			isLeapYear = false;
		}
		
		// Some space between input values and output values
		System.out.println();
		
		// Beginning of the branch system to determine what to output based upon what month was given
		// What is determined here first is almost the same for everything after it except for the
		// specific parts that are commented which are different from some things
		if (month == 1) {
			
			monthName = "January";								// Assigning the months name to a variable
			monthHeader = monthName + " " + year;				// Combining the money and year together for a neater output
			monthLength = monthHeader.length();					// Calculating the length of both strings together
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;		// Calculating the amount of spaces needed before the month name and year
			
			// For loop to add the amount of spaces to a variable for easier output
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			// Beginning of the output in a neat format
			// Both the header of the calendar and then the next line being the days of the week
			// which are a constant and never change
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			// Beginning of a switch to determine which day of the week the month starts
			// Which is determined based off the input the user has given
			// and also handles the first row of the calendar
			dayOfFirst = daysOfWeek.get(day);
			
			// Variable that keeps tracks of which day it is
			int count = 1;
			
			// String variable holding onto the amount of spaces needed to add to the
			// first of the month to be formatted correctly
			String x = "";
			
			// Loop to determine how many spaces are before the first of the month
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			// Loop to determine the amount of days are within the first row
			// of the calendar and the formatting between them
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			// Printing the first week of the month with correct formatting
			System.out.println(x);
			
			// Check to determine if the end of the week is near
			int modCheck = 1;
			
			// Loop to generate the days of the week based upon how long the month is i.e how many days in the month
			while (count < 32) {
				
				if (modCheck % 7 == 0) {					// Modulus calculation to check for what to do when
					if (count == 8 || count == 9) {			// the program gets to the end of the week (this line also handles some error with formatting I had to work around)
						System.out.println("  " + count);	// and the formatting of the numbers for each
					}										// day within the month
					else {
						System.out.println(" " + count);
					}
				}
				else {											// This other part of the branch handles the formatting
					if (count < 10) {							// of the days between the beginning and end of each week
						System.out.print("  " + count + " ");	// along with the numbers that over flow from the first week
					}											// depending on the start of the month and their formatting
					else {
						System.out.print(" " + count + " ");
					}
				}
				modCheck++;									// Increments the modCheck variable + 1
				count++;									// Increments the count variable + 1
			}
		}
		
		/*
		 *  Here is a heads up comment about the rest of the code below.
		 *  The rest of the code only has minor changes from the above code
		 *  being that the total amount of days in that month are different with
		 *  the exception to February which has a small difference to account for leap years
		 *  and those changes are commented correctly.
		 *  
		 *  So therefore within the code below I will only be commenting the parts that are different
		 *  and not repeating the above part that are commented.
		 */
		else if (month == 2) {
			
			monthName = "February";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			if (isLeapYear == true) {								// Check to see if the year inputed is a leap year
				febDays = 29;
			}
			else {
				febDays = 28;
			}
			
			while (count <= febDays) {							//Amount of days are different depending upon being a leap year or not
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}
				}
				modCheck++;
				count++;
			}
		}
		else if (month == 3) {
			
			monthName = "March";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 32) {
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}	
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}
				}
				modCheck++;
				count++;
			}
		}
		else if (month == 4) {
			
			monthName = "April";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 31) {							//Amount of days are one less because its a shorter month
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}
				}
				modCheck++;
				count++;
			}
		}
		else if (month == 5) {
			
			monthName = "May";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 32) {
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 6) {
			
			monthName = "June";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 31) {							//Amount of days are one less because its a shorter month
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 7) {
			
			monthName = "July";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 32) {
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 8) {
			
			monthName = "August";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 32) {
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 9) {
			
			monthName = "September";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 31) {							//Amount of days are one less because its a shorter month
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 10) {
			
			monthName = "October";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 32) {
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 11) {
			
			monthName = "November";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 31) {							//Amount of days are one less because its a shorter month
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}
		}
		else if (month == 12) {
			
			monthName = "December";
			monthHeader = monthName + " " + year;
			monthLength = monthHeader.length();
			amtSpaces = (CALENDER_SIZE - monthLength) / 2;
			
			for (int i = 0; i < amtSpaces; i++) {
				monthHeaderFormat += " ";
			}
			
			System.out.println(monthHeaderFormat + monthHeader);
			System.out.println(DAY_NAMES);

			dayOfFirst = daysOfWeek.get(day);
			
			int count = 1;
			
			String x = "";
			
			for (int i = 1; i < dayOfFirst; i++) {
				x += "    ";
			}
			
			for (int i = dayOfFirst; i < 8; i++) {
				x += "  " + count + " ";
				count++;
			}
			
			System.out.println(x);
			
			int modCheck = 1;
			
			while (count < 32) {
				
				if (modCheck % 7 == 0) {
					if (count == 8 || count == 9) {
						System.out.println("  " + count);
					}
					else {
						System.out.println(" " + count);
					}
				}
				else {
					if (count < 10) {
						System.out.print("  " + count + " ");
					}
					else {
						System.out.print(" " + count + " ");
					}	
				}
				modCheck++;
				count++;	
			}		
		}
	}
}
