package project_demo_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PPM_Generator {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream inputFiles[] = new FileInputStream[9];
		
		for (int i = 0; i < 9; i++) {
			
			inputFiles[i] = new FileInputStream("Photo_" + String.valueOf(i + 1) + ".ppm");
			
		}
		
		Scanner scanners[] = new Scanner[9];
		
		for (int i = 0; i < 9; i++) {
			
			scanners[i] = new Scanner(inputFiles[i]);
			
		}
		
		FileOutputStream outputFile = new FileOutputStream("output.ppm");
		PrintWriter writer = new PrintWriter(outputFile);
		
		// Jump over the first 4 values in each input file.
		for (int i = 0; i < 9; i++) {
			
			scanners[i].next();
			scanners[i].next();
			scanners[i].next();
			scanners[i].next();
			
		}
		
		// Write the "header" to output file.
		writer.println("P3\n800 600\n255");
		
		for (int i = 0; i < 800 * 600 * 3; i++) {
			
			int[] arr = new int[9];
			
			for (int j = 0; j < 9; j++) {
				
				arr[j] = scanners[j].nextInt();
				
			}
			
			// Get the majority element in arr.
			// [3, 3, 4, 3, 3] - > [3, 3, 3, 3, 4] -> 3
			// 1) Sort the arr.
			// 2) Get the median.
			Arrays.sort(arr);
			writer.println(arr[arr.length / 2]);
			
		}
		
		writer.close();
		outputFile.close();
		
		for (int i = 0; i < 9; i++) {
			
			scanners[i].close();
			inputFiles[i].close();
			
		}
		
	}

}
