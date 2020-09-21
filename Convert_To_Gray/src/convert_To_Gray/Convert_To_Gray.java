package convert_To_Gray;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Convert_To_Gray {
	
	/*
	 * ++++++++++++++++++++++++++DISCLAIMER+++++++++++++++++++
	 * I went ahead and added the input files to the project here to make it easier for you.
	 * However, I left out the output files that way you know the files that the program
	 * outputs are actually from the code I have produced.
	 */
	
	public static void main(String[] args) throws IOException {
		
		// Creating variable and assigning it to a scanner
		// so that it may look for the correct file
		Scanner userInput = new Scanner(System.in);
		
		// Asking the user for the correct file name
		// and assigning it to a variable
		System.out.println("What is the name of your file? (.ppm file no need to add extension) ");
		String userSelectedFile = userInput.next();
		
		// Creating the input stream and assigning it to a variable
		FileInputStream inputFile = new FileInputStream(userSelectedFile + ".ppm");
		
		// Creating a scanner just to look through the file
		Scanner userFile = new Scanner(inputFile);
		
		// Creating the output stream and assigning it to a variable
		// and also creating the writer object for the output file
		FileOutputStream outputFile = new FileOutputStream(userSelectedFile.replace("colorImage", "grayscaleImage") + ".ppm");
		PrintWriter writer = new PrintWriter(outputFile);
		
		// Creating some variable for calculation and writer printing
		String file_P3_Constant;
		long file_Res_Width, file_Res_Height; 
		int file_Color_Depth;
		
		// Getting the first four lines of the image and assigning
		// them to variable for printing later
		file_P3_Constant = userFile.next();
		file_Res_Width = userFile.nextLong();
		file_Res_Height = userFile.nextLong();
		file_Color_Depth = userFile.nextInt();
		
		// Assigning the long and int variables so they can be written easily later
		String file_Res_String = "" + file_Res_Width + " " + file_Res_Height + "\n";
		
		// Some more variables for later
		// which are used in pixel color to gray calculation
		double grayCalc;
		int value;
		
		// Writing the first four lines of the output file from previous read lines
		writer.println(file_P3_Constant + "\n" + file_Res_String + file_Color_Depth);
		
		// Simple output to console to know the program is working
		System.out.println("Converting...");
		
		// For loop to read through each line of the input file
		for (int i = 0; i < file_Res_Width * file_Res_Height; i++) {
			
			// Variable of the red, blue, and green pixels within the input file
			int x, y, z;
			
			// Reading the pixels and assigning them to a variable
			x = userFile.nextInt();
			y = userFile.nextInt();
			z = userFile.nextInt();
			
			// Calculation for figuring out the grey scale version of the the pixel
			// and converting it to an integer
			grayCalc = ((0.3 * x) + (0.59 * y) + (0.11 * z));
			value = (int) grayCalc;
			
			// Writing each value to the output file
			writer.println(value + "\n" + value + "\n" + value + "\n");
			
		}
		
		// Simple output to console to know the program has finished doing its job
		System.out.println("Done Converting!");
		
		// Closing of each scanner and each input and output stream
		writer.close();
		outputFile.close();
		userFile.close();
		userInput.close();
	}
}
