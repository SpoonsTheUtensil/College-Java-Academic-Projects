package payroll_Program;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Payroll {

	public static void main(String[] args) {
		
		// Creating the variables needed
		String lastName, social;
		double hourlyPayRate, grossPay, fedTax, stateTax, totalTax, netPay;
		int hoursWorked;
		
		// Creating the scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Asking for user's lastname and assigning it to the variable lastName
		System.out.print("Enter your last name: ");
		lastName = input.next();
		
		// Asking for user's last 4 digits of their social security number
		// and assigning it the variable of social
		System.out.print("SSN (last 4 digits): ");
		social = input.next();
		
		// Asking the user for their hourly pay rate and
		// assigning it to the variable hourlyPayrate
		System.out.print("Hourly pay rate: ");
		hourlyPayRate = input.nextDouble();
		
		// Asking the user for the amount of hours they worked
		// and assigning it the the variable hoursWorked
		System.out.print("Hours worked: ");
		hoursWorked = input.nextInt();
		
		// Just closing the scanner
		input.close();
		
		// Calculating of the gross pay, federal and state tax withheld
		// and figuring out the netPay after all taxs are taken out
		grossPay = hourlyPayRate * hoursWorked;
		fedTax = grossPay * 0.15;
		stateTax = grossPay * 0.05;
		totalTax = fedTax + stateTax;
		netPay = grossPay - totalTax;
		
		// Solution to the appropriate amount of decimals places to be show
		// at the final format
		DecimalFormat df = new DecimalFormat("#.00");
		
		// Format of the end result being displayed to the user
		System.out.print("\n");
		System.out.print("Payroll Summary for: " + lastName + "\n");
		System.out.print("SSN (last 4 digits): " + social + "\n");
		System.out.print("You worked " + hoursWorked + " hours at $" + (df.format(hourlyPayRate)) + " per hour.\n");
		System.out.print("\n");
		System.out.print("Gross pay:              $  " + (df.format(grossPay)) + "\n");
		System.out.print("Federal withholding:    $  " + (df.format(fedTax)) + "\n");
		System.out.print("State withholding:      $   " + (df.format(stateTax)) + "\n");
		System.out.print("---------------------------------\n");
		System.out.print("Net pay:                $  " + (df.format(netPay)));
	}
	
}
