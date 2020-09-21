package skating_Medals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Skating_Winner_Calculation {
	
	public static void main(String[] args) throws IOException{
		
		// Creating the variables needed
		double skater1SP, skater1FS, skater2SP, skater2FS, skater3SP, skater3FS, skater1Total, skater2Total, skater3Total;
		double gold, silver, bronze;
		
		// Creating the file input and output streams alone with the scanner and object needed to
		// output to a file (PrintWriter)
		FileInputStream fileByteStream;
		FileOutputStream fileStream = null;
		PrintWriter outFS = null;
		Scanner inFS;
		
		// Assigning the sample input file to the variable fileByteStream to read the values
		// and creating a scanner to look throgh the file and get the values
		fileByteStream = new FileInputStream("Sample Input.txt");
		inFS = new Scanner(fileByteStream);
		
		// The scanner reads each line of the file and
		// assigns it to the needed variable
		
		// The text file is laid out like
		// {SF VALUE}
		// {FS VALUE}
		// {SF VALUE}
		// {FS VALUE}
		// {SF VALUE}
		// {FS VALUE}
		skater1SP = inFS.nextDouble();
		skater1FS = inFS.nextDouble();
		skater2SP = inFS.nextDouble();
		skater2FS = inFS.nextDouble();
		skater3SP = inFS.nextDouble();
		skater3FS = inFS.nextDouble();
		
		// Calculating the score of each skater
		skater1Total = skater1SP + skater1FS;
		skater2Total = skater2SP + skater2FS;
		skater3Total = skater3SP + skater3FS;
		
		
		/* Taking each skaters score and testing it against others to get the correct
		 * gold, silver, bronze medal
		 * 
		 *  Here first it goes through with the first skaters score testing against
		 *  each other skater. Then assigning that to gold if the score is greater
		 *  then both of the other two. Then testing the second skaters score against
		 *  the other skaters score and if its greater then assigning that one to silver
		 *  and the other skaters to bronze.
		 *  
		 *  Finally, after that proceeding to acquire the file outputting the scores to
		 *  and outputting them to that file in the required format.
		 */
		if (skater1Total > skater2Total) {
			if (skater1Total > skater3Total) {
				gold = skater1Total;
				if (skater2Total > skater3Total) {
					silver = skater2Total;
					bronze = skater3Total;
					fileStream = new FileOutputStream("Sample Output.txt");
					outFS = new PrintWriter(fileStream);
					outFS.printf("Gold: %.2f\n", gold);
					outFS.printf("Silver: %.2f\n", silver);
					outFS.printf("Bronze: %.2f\n", bronze);
					outFS.flush();
					fileStream.flush();
					inFS.close();
				}
				// This part of the last check is for when the second skaters score isn't greater then the third skaters
				else {
					silver = skater3Total;
					bronze = skater2Total;
					fileStream = new FileOutputStream("Sample Output.txt");
					outFS = new PrintWriter(fileStream);
					outFS.printf("Gold: %.2f\n", gold);
					outFS.printf("Silver: %.2f\n", silver);
					outFS.printf("Bronze: %.2f\n", bronze);
					outFS.flush();
					fileStream.flush();
					inFS.close();
				}
			}
		}
		
		// This branch/check works the exact same as above just checking first
		// with a different skaters score (this one being skater 2)
		if (skater2Total > skater1Total) {
			if (skater2Total > skater3Total) {
				gold = skater2Total;
				if (skater1Total > skater3Total) {
					silver = skater1Total;
					bronze = skater3Total;
					fileStream = new FileOutputStream("Sample Output.txt");
					outFS = new PrintWriter(fileStream);
					outFS.printf("Gold: %.2f\n", gold);
					outFS.printf("Silver: %.2f\n", silver);
					outFS.printf("Bronze: %.2f\n", bronze);
					outFS.flush();
					fileStream.flush();
					inFS.close();
				}
				else {
					silver = skater3Total;
					bronze = skater1Total;
					fileStream = new FileOutputStream("Sample Output.txt");
					outFS = new PrintWriter(fileStream);
					outFS.printf("Gold: %.2f\n", gold);
					outFS.printf("Silver: %.2f\n", silver);
					outFS.printf("Bronze: %.2f\n", bronze);
					outFS.flush();
					fileStream.flush();
					inFS.close();
				}
			}
		}
		
		// This branch/check works the exact same as above just checking first
				// with a different skaters score (this one being skater 3)
		if (skater3Total > skater1Total) {
			if (skater3Total > skater2Total) {
				gold = skater3Total;
				if (skater1Total > skater2Total) {
					silver = skater1Total;
					bronze = skater2Total;
					fileStream = new FileOutputStream("Sample Output.txt");
					outFS = new PrintWriter(fileStream);
					outFS.printf("Gold: %.2f\n", gold);
					outFS.printf("Silver: %.2f\n", silver);
					outFS.printf("Bronze: %.2f\n", bronze);
					outFS.flush();
					fileStream.flush();
					inFS.close();
				}
				else {
					silver = skater2Total;
					bronze = skater1Total;
					fileStream = new FileOutputStream("Sample Output.txt");
					outFS = new PrintWriter(fileStream);
					outFS.printf("Gold: %.2f\n", gold);
					outFS.printf("Silver: %.2f\n", silver);
					outFS.printf("Bronze: %.2f\n", bronze);
					outFS.flush();
					fileStream.flush();
					inFS.close();
				}
			}
		}
	}
}
