/**
 * This class takes values inserted by the user and calculates the number of possible
 * combinations available for the values using a recursive method.
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

public class BCRecursive {

	public static void main(String[] args) {

		long startTime; //This variable will be used to store the current system time at the start of the calculation.
		long endTime; //This variable will be used to store the current system time at the end of the calculation.
		long totalTime; //This variable will be used to store the total run time of the calculation.
		String cont; //This variable determines whether the program will continue to run.
		BufferedWriter recursiveResults = null; //This sets up a buffered writer for my file.
		Scanner input = new Scanner(System.in); //This instantiates a scanner that will be used to read user input.

		do {

			try {

				try {

					recursiveResults = new BufferedWriter(new FileWriter("BCRecursiveFile", true)); //This instantiates my buffered writer as a file writer.

					System.out.println("Please enter a value for n:");

					int n = input.nextInt(); //The value the user inserts represents how many total items there are.
					
					System.out.println();

					System.out.println("Please enter a value for k:");

					int k = input.nextInt(); //The value the user inserts represents the number of items in a subset.
					
					System.out.println();

					startTime = System.currentTimeMillis(); //Start time of the calculation.

					long total = factorial(n) / (factorial(n-k) * factorial(k)); //This is the total possible amount of combinations.

					endTime = System.currentTimeMillis(); //End time of the calculation.

					//If the total run time is less than 1 second, then the total time is rounded up to 1 second.
					//Otherwise, the total run time is the normal value.
					if((endTime-startTime) / 1000 < 1) {

						totalTime = 1;

					}else {

						totalTime = (endTime - startTime)/1000;

					}//end else

					System.out.printf("There are %d ways to compute %d subsets from %d items.%n", total, k, n);

					System.out.println();
					
					String result = n + ", " + k + ", " + total + ", " + totalTime + " seconds."; //This is the string I will write to the file.

					recursiveResults.write(result); //This appends the result to my file.

					recursiveResults.newLine();

				}finally{

					recursiveResults.close(); //This closes my file.

				}//end finally

			}catch(IOException exception) {

				System.out.print(exception); //If an exception is caught, it is printed to the screen.

			}//end catch
			
			System.out.println("Would you like to enter another n and k? (Y/N): ");
			
			cont = input.next(); //Sets my cont value to what the user enters.
			
			System.out.println();

		}while(cont.equalsIgnoreCase("Y")); //This loop will continue to run as long as the user inputs y.

	}//end main

	/**
	 * This method calculates the factorial for the value inserted.
	 * @param number
	 * @return
	 */
	private static long factorial(int number) {

		if(number == 1) {

			return 1;

		}else {

			return number * factorial(number - 1);

		}//end else

	}//end factorial

}//end BCRecursive
