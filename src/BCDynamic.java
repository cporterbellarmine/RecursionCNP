/**
 * This class takes values inserted by the user and calculates the number of possible
 * combinations available for the values using a dynamic method.
 * 
 * @author christinaporter
 * @version 11/04/2019
 * Recursive Sequences Project
 * Fall 2019
 */


import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class BCDynamic {

	public static void main(String[] args) {

		long startTime; //This variable will be used to store the current system time at the start of the calculation.
		long endTime; //This variable will be used to store the current system time at the end of the calculation.
		long totalTime; //This variable will be used to store the total run time of the calculation.
		String cont; //This variable determines whether the program will continue to run.
		BufferedWriter dynamicResults = null; //This sets up a buffered writer for my file.
		Scanner input = new Scanner(System.in); //This instantiates a scanner that will be used to read user input.

		do {
			
			try {
				
				try {
					
					long nFac = 0; //This resets my n factorial value to 0 every time the loop is run.
					long kFac = 0; //This resets my k factorial value to 0 every time the loop is run.
					long nminuskFac = 0; //This resets my n minus k factorial value to every time the loop is run.
					long product = 1; //This resets my product value to 1 every time the value is run.
					dynamicResults = new BufferedWriter(new FileWriter("BCDynamicFile", true)); //This instantiates my file as both a BufferedWriter and a FileWriter.
					
					System.out.println("Please enter a value for n:");
	
					int n = input.nextInt(); //The value that the user inserts will be the total number of items.
					
					System.out.println();
	
					System.out.println("Please enter a value for k:");
	
					int k = input.nextInt(); //The value that the user inserts will be the number of items in a subset.
					
					System.out.println();
	
					int diff = n - k; //This represents the difference between n and k.
	
					startTime = System.currentTimeMillis(); //Start time of the calculation.
					
					//This loop calculates the factorial of numbers starting from 1 and up to n.
					//As i passes the values for k, n-k, and n the values are saved for future use.
					for(int i = 1; i <= n; i++) {
	
						product = product * i;
	
						if(i == k) {
	
							kFac = product;
	
						}//end if
	
						if(i == diff) {
	
							nminuskFac = product;
	
						}//end if
	
						if(i == n) {
	
							nFac = product;
	
						}//end if
	
					}//end for
	
					long total = nFac / (nminuskFac * kFac); // This uses the values saved to compute the binomial coefficient.
	
					endTime = System.currentTimeMillis(); //End time of the calculation.
					
					//If the total run time is less than 1 second, then the total time is rounded up to 1 second.
					//Otherwise, the total run time is the normal value.
					if(endTime-startTime < 1) {
						
						totalTime = 1;
						
					}else {
	
						totalTime = (endTime - startTime)/1000;
					
					}//end else
	
					System.out.printf("There are %d ways to compute %d subsets from %d items.%n", total, k, n);
					
					System.out.println();
					
					String result = n + ", " + k + ", " + total + ", " + totalTime + " seconds."; //This is the string that will be appended to my file.
					
					dynamicResults.write(result); //This appends the string to my file.
					
					dynamicResults.newLine();
	
				}finally{
					
					dynamicResults.close(); //This closes my file.
					
				}//end finally
	
			}catch(IOException exception) {
				
				System.out.print(exception); //If there is an exception caught, it is printed to the screen.
				
			}//end catch
			
			System.out.println("Would you like to enter another n and k? (Y/N): ");
			
			cont = input.next(); //Sets my cont value to what the user enters.
			
			System.out.println();
		
		}while(cont.equalsIgnoreCase("Y")); //This loop will continue to run as long as the user inputs y.

	}//end main

}//endTestApplication
