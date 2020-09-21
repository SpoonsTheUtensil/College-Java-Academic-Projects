package population_Growth;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Population_Growth {
	
	public static void main(String[] args) throws IOException{
		
		// Creating the need variables
		FileInputStream fileByteStream;
		Scanner inFS;
		int townACurPop, townBCurPop, count;
		double townAGrowthRate, townBGrowthRate, growthCalcA, growthCalcB;
		
		// Assigning the correct file to acquire the input needed for
		// the calculations and assigning the scanner to the variable
		fileByteStream = new FileInputStream("Sample Text.txt");
		inFS = new Scanner(fileByteStream);
		
		// Assigning the inputs from the file to the correct variables
		townACurPop = inFS.nextInt();
		townBCurPop = inFS.nextInt();
		townAGrowthRate = inFS.nextDouble();
		townBGrowthRate = inFS.nextDouble();
		
		// Variable to keep track of how many years have gone by
		count = 1;

		// For loop needed to keep doing the growth calculation until Town A is larger then Town B
		for (int i = 1; i < 100; ++i) {
			
			// The calculation of the growth of each town
			growthCalcA = townACurPop * Math.pow((1 + townAGrowthRate), i);
			growthCalcB = townBCurPop * Math.pow((1 + townBGrowthRate), i);
			count += 1;
			
			// Needed to check if Town A is larger then Town B and if it is
			// to break out of the loop so it doesn't do any unneeded calculations
			if (growthCalcA > growthCalcB) {
				System.out.println("Number of years: " + count);
				System.out.println("Population of town A: " + Math.round(growthCalcA));
				System.out.println("Population of town B: " + Math.round(growthCalcB));
				break;
			}
		}
		
		// Closing the stream from the input file and closing the scanner
		fileByteStream.close();
		inFS.close();
	}

}
