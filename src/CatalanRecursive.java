/**
 * This class takes values inserted by the user and calculates the 
 * nth Catalan number using a recursive method.
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

public class CatalanRecursive {

	public static void main(String[] args) {

		long startTime; //This variable will be used to store the current system time at the start of the calculation.
		long endTime; //This variable will be used to store the current system time at the end of the calculation.
		long totalTime; //This variable will be used to store the total run time of the calculation.
		String cont; //This variable determines whether the program will continue to run.
		Scanner input = new Scanner(System.in); //This instantiates a scanner that will be used to read user input.
		BufferedWriter catalanRecursiveResults = null; //This sets up a buffered writer for my file.

		do {

			try {

				try {

					catalanRecursiveResults = new BufferedWriter(new FileWriter("CatalanRecursiveFile", true)); //This instantiates my buffered writer as a file writer.

					System.out.println("Please enter a value for n: ");

					int n = input.nextInt(); //The value the user inserts will be the nth Catalan value we will calculate.
					
					System.out.println();

					startTime = System.currentTimeMillis(); //Start time of the calculation.

					long catalan = factorial(2 * n) / (factorial(n + 1) * factorial (n)); //This uses the factorial values to calculate the Catalan number at n.

					endTime = System.currentTimeMillis(); //End time of the calculation.

					//If the total run time is less than 1 second, then the total time is rounded up to 1 second.
					//Otherwise, the total run time is the normal value.
					if(endTime - startTime < 1) {

						totalTime = 1;

					}else {

						totalTime = (endTime - startTime)/1000;

					}//end else

					System.out.printf("C(%d) = %d%n", n, catalan);
					
					System.out.println();

					String result = n + ", " + catalan + ", " + totalTime + " seconds."; //This is the string that will be appended to my file.

					catalanRecursiveResults.write(result); //This appends the result to my file.

					catalanRecursiveResults.newLine();

				}finally{

					catalanRecursiveResults.close(); //This closes my file.

				}//end finally

			}catch(IOException exception) {

				System.out.print(exception); //If an exception is caught, it is printed to the screen.

			}//end catch

			System.out.println("Would you like to enter another n? (Y/N): ");

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

}//end CatalanRecursive
