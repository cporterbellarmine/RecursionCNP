/**
 * This class takes values inserted by the user and calculates the 
 * nth Catalan number using a dynamic method.
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

public class CatalanDynamic {

	public static void main(String[] args) {

		long startTime; //This variable will be used to store the current system time at the start of the calculation.
		long endTime; //This variable will be used to store the current system time at the end of the calculation.
		long totalTime; //This variable will be used to store the total run time of the calculation.
		String cont; //This variable determines whether the program will continue to run.
		Scanner input = new Scanner(System.in); //This instantiates a scanner that will be used to read user input.
		BufferedWriter catalanDynamicResults = null; //This sets up a buffered writer for my file.


		do {
			try {
				try {
					
					long product = 1; //This resets my product value to 1 every time the loop is run
					long nFac = 0; //This resets my nFac value to 0 every time the loop is run.
					long twonFac = 0; //This resets my twonFac value to 0 every time the loop is run.
					long nPlusOneFac = 0; //This resets my nPlusOneFac value to 0 every time the loop is run.
					catalanDynamicResults = new BufferedWriter(new FileWriter("CatalanDynamicFile", true)); //This instantiates my file as both a BufferedWriter and a FileWriter.

					System.out.println("Please enter a value for n: ");

					int n = input.nextInt(); //The value the user inserts will be the nth Catalan value we will calculate.
					
					System.out.println();

					startTime = System.currentTimeMillis(); //Calcuation start time.

					//This loop calculates the factorial of numbers starting from 1 and up to n.
					//As i passes the values for n, n+1, and 2n values are saved for future use.
					for(int i = 1; i <= n * 2; i++) {

						product = product * i;

						if(i == n) {

							nFac = product;

						}//end if

						if(i == n + 1) {

							nPlusOneFac = product;

						}//end if

						if(i == 2 * n) {

							twonFac = product;

						}//end if

					}//end for

					long catalan = twonFac / (nPlusOneFac * nFac); //The saved values are used to calculate the catalan number at n.

					endTime = System.currentTimeMillis(); //Calculation end time.

					//If the total run time is less than 1 second, then the total time is rounded up to 1 second.
					//Otherwise, the total run time is the normal value.
					if(endTime - startTime < 1) {

						totalTime = 1;

					}else {

						totalTime = (endTime - startTime)/1000;

					}//end else

					System.out.printf("C(%d) = %d%n", n, catalan);
					
					System.out.println();

					String result = n + ", " + catalan + ", " + totalTime + "seconds."; //This is the string that will be appended to my file.

					catalanDynamicResults.write(result); //This appends the result string to the file.

					catalanDynamicResults.newLine();

				}finally{

					catalanDynamicResults.close(); //This closes the file.

				}//end finally

			}catch(IOException exception) {

				System.out.print(exception); //If an exception is caught, it is printed to the screen.

			}//end catch

			System.out.println("Would you like to enter another n? (Y/N): ");

			cont = input.next(); //Sets my cont value to what the user enters.

			System.out.println();

		}while(cont.equalsIgnoreCase("Y")); //This loop will continue to run as long as the user inputs y.

	}//end main

}//end CatalanDynamic
