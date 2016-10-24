/* Christian Miljkovic
 * 02/10/16
 * This program is a game called rock paper scissors where the user is asked to input (r) for rock, (p) for paper
 * and (s) for scissors and then the computer randomly generates either rock paper or scissors, and then the program
 * decides (based upon the rules of the game) who wins the game.
 */

import java.util.Scanner;
public class RockPaperScissors 
{

	public static void main(String[] args) 
	{
		//create the initial greeting/heading for the program
		System.out.println("=========================================");
		System.out.println("Welcome to the Rock-Paper-Scissors game!");
		System.out.println("=========================================\n");
		
		//ask the user for their choice of rock paper or scissors in the form of a string
		Scanner input = new Scanner(System.in);
		System.out.print("Select your element:\n(r)ock, (p)aper, or (s)cissors: ");
		String user_choice = input.nextLine();
		System.out.print("\n"); //used for formatting
		
		
		
		
		// create and if else if statement in order to print out what the user chose in the previous part of the 
		// program and to exit the program if the user chose an invalid element
		if (user_choice.equals("r"))
			System.out.println("You chose rock.");
		
		else if (user_choice.equals("p"))
			System.out.println("You chose paper.");
		
		else if (user_choice.equals("s"))
			System.out.println("You chose scissors.");
		
		else {
			System.out.print("Error you did not select a valid element.");
			System.exit(0);
		}
		
		
		//create a random integer that correlates to rock paper or scissors for the computer
		int random_num = (int)(Math.random()*3 + 1);
		
		//declare the computers choice 
		String comp_choice=null;
		
		//create a switch statement in order to match the random int to the computers choice
		switch (random_num) 
		{
			case 1: comp_choice="r";
					System.out.println("Computer chose rock.\n");
					break;
			case 2: comp_choice="p";
					System.out.println("Computer chose paper.\n");
					break;
			case 3: comp_choice="s";
					System.out.println("Computer chose scissors.\n");
					break;
		}
				
		//create if else statements in order to determine who is the winner	based upon the rules of the game
		//use logical operators for the if else if statements since you are using two booleans in each statement
		if (comp_choice=="r" && user_choice.equals("s")) 
			System.out.print("Computer wins! (rock beats scissors)");
			
		else if (comp_choice=="p" && user_choice.equals("r")) 
			System.out.print("Computer wins! (paper beats rock)"); 
		
		else if (comp_choice=="s" && user_choice.equals("p"))
			System.out.print("Computer wins! (scissors beats paper)");
		
		else if (comp_choice=="s" && user_choice.equals("r")) 
			System.out.print("You win! (rock beats scissors)");
			
		else if (comp_choice=="r" && user_choice.equals("p")) 
			System.out.print("You win! (paper beats rock)"); 
		
		else if (comp_choice=="p" && user_choice.equals("s")) 
			System.out.print("You win! (scissors beats paper)"); 
		
		else
			System.out.print("It is a tie!");
		
	}

}

