/*
Christian Miljkovic
02/02/16
This program asks the user to input how much money they want to put on their metro card
and then tells them how many rides they can get with that much money. 
 */

//import Scanner
import java.util.Scanner;
public class MetroCard 
{

	public static void main(String[] args) 
	{
		double money = 0; //declare this variable so you can use it in the loop and outside it
		boolean counter = true; //declare the boolean variable for the loop
		
		//create a while loop for data validation
		while (counter) 
		{
			//asks the user to input how much money they want to put on their metrocard 
			System.out.print("Enter the amount of money you wish to put on your card: ");
			Scanner input = new Scanner(System.in);
			
			//convert the input to this variable
			money = input.nextDouble(); 
			
			//use an if else statement for data validation
			if (money < 0)
				System.out.println("Please enter a positive integer.\n");
			
			else
				break;
			
		}
		
		//use an if statement in order to apply a 11% bonus if the amount is above 5.50
		if (money >= 5.50) 
			money += money*.11;
		
		//declare the fare variable
		double fare = money /2.75;
		
		//print out the amount of fares the user would get if they put however much money they did on the metrocard
		System.out.print("You will have " + (int)fare + " fare(s).");
	}

}
