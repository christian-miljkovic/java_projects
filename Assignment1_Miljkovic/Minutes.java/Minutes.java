/*
Christian Miljkovic
02/02/16
This program asks the user to enter any number of minutes and then takes that number
and turns it into the amount of years and days those amount of minutes equate to.
*/

//import Scanner
import java.util.Scanner;
public class Minutes 
{

	public static void main(String[] args) 
	{
		int minute = 0; //declare this variable in order to use it in the loop and outside it
		boolean counter = true; //declare bool for the loop
		
		//create a loop for data validation
		while (counter) 
		{ 
			
			//ask the user to input any number of minutes using Scanner
			System.out.print("Enter the number of minutes: ");
			Scanner input = new Scanner(System.in);
			minute = input.nextInt(); //convert the input to the minute variable
			
			//use if else statement for data validation
			if (minute < 0)
				System.out.println("Please input a positive integer.\n");
			
			else
				break;
		
		}
		
		//take the inputed minutes and convert it while also declaring the variables
		int hours = (minute/60);
		int days = hours/24;
		int years = days/365;
		int days_remainder = days % 365; //since this is already converted to days take the remainder is what is needed
		
		//print out the number of years and days the inputed amount of minutes equates to
		System.out.print(minute + " minutes is approximately " + years + " years and " + days_remainder + " days.");
	}

}
