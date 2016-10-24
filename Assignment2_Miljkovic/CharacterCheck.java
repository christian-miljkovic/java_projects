/* Christian Miljkovic
 * 02/10/16
 * This program asks the user for an integer and verifies whether it is a positive integer
 * after verifying the input (and if it passes) the program then converts the integer into its hexidecimal 
 * and Unicode-16 character equivalent as well as giving information on the unicode character such as whether it is a digit or letter and etc.
 */

import java.util.Scanner;
public class CharacterCheck 
{
	
	public static void main(String[] args) 
	{
	//declare the variable for the scanner
	int user_integer=0;
	while (true) //create a while loop in order to repeatedly ask for new input if the user does not give a non-negative integer
	{	
	//ask the user for input using Scanner
	Scanner input = new Scanner(System.in);
	System.out.print("Enter an integer: ");
	user_integer = input.nextInt();
	
	// use if else statement in order to make sure that the input was a non-negative number
	if (user_integer < 0)
		System.out.print("This program does not accept negative integers\n");
	else
		break;
	
	}
	//format and print out the conversion of the integer given by the user
	//for formatting reasons create a block of 8 characters on the first integer then using printf convert the integer 
	//into hexidecimal and the character
	System.out.printf( "%8d (0x%X) is Unicode-16 for character '%C'"+"\n",user_integer, user_integer,user_integer);
	Character ch = new Character((char) user_integer); //convert the user's integer into a character
	
	//using if statements and character methods such as .isDigit(ch) in order to determine 
	//whether the converted character is a digit, letter, uppercase, Ideogrpahic, and etc.
	if (ch.isDigit(ch))
		System.out.print("\tit is a Digit"); // use \t before the 'it' for formatting reasons and print out the description
	
	if (ch.isLetter(ch))
		System.out.println("\tit is a Letter");
	
	if (ch.isISOControl(ch))
		System.out.println("\tit is an ISO Control character");
	
	if (ch.isIdeographic(ch))
		System.out.println("\tit is an Ideographic character");
	
	if (ch.isSpaceChar(ch))
		System.out.println("\tit is a Space character");
	
	if (ch.isLowerCase(ch))
		System.out.println("\tit is a Lower case character");
	
	if (ch.isUpperCase(ch))
		System.out.println("\tit is an Upper case character");

	}
			
}
