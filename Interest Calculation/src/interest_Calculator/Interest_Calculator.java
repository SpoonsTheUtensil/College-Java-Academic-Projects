package interest_Calculator;

import java.util.Scanner;

public class Interest_Calculator {
	
	public static void main(String[] args) {
		
		// Creating the variables to be used and assigning them to the
		// appropriate primitive data type
		double balanceOnBill, payment, monthlyInterestRate, avgDailyBalance, interestOnUnpaidBalance;
		int numDaysInCycle, numDaysBeforeAssignedDate;
		
		// Creating a scanner object
		Scanner input = new Scanner(System.in);
		
		// Asking for user input about the balance shown on the bill and
		// assigning that to the variable balanceOnBill
		System.out.println("What is the balance shown on your bill?");
		balanceOnBill = input.nextDouble();
		
		// Asking for user input about how many days are in their billing cycle and
		// assigning that to the variable numDaysInCycle
		System.out.println("How many days are within your billing cycle?");
		numDaysInCycle = input.nextInt();
		
		// Asking for user input about how much the payment is for this month and
		// assigning that to the variable payment
		System.out.println("How much is your payment for this month?");
		payment = input.nextDouble();
		
		// Asking for user input about how many days ahead of the assigned payment date they were and
		// assigning that to the variable numDaysBeforeAssignedDate
		System.out.println("How many days are you ahead of your assigned payment date?");
		numDaysBeforeAssignedDate = input.nextInt();
		
		// Asking for user input about their monthly interest rate and
		// assigning that to the variable monthlyInterestRate
		System.out.println("What is your monthly interest rate?");
		monthlyInterestRate = input.nextDouble();
		
		// Just closing the scanner
		input.close();
		
		// Calculation of the average daily balance and interest on the unpaid balance
		avgDailyBalance = ((balanceOnBill * numDaysInCycle)-(payment * numDaysBeforeAssignedDate)) / numDaysInCycle;
		interestOnUnpaidBalance = avgDailyBalance * monthlyInterestRate;
		
		// Outputting the interest on the unpaid balance back to the user
		System.out.println("Your interest on the unpaid balance will be: " + interestOnUnpaidBalance);
		
	}
	/*
	 *  Just a note to you as well, I tend to read instructions and think about the vague meaning of things so I wasn't
	 *  sure if you want the monthly interest of 0.0152 to be a hardcoded number so I just made it to be asked to the user
	 *  for flexibility in using any number for the monthly interest.
	 */
}
