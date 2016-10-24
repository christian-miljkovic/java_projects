/* 
Christian Miljkovic
02/02/16
This program ask the user for a number of students then asks them to input the student names and scores
Then the program at the end displays the student with the highest score and their score.

*/
//import Scanner
import java.util.Scanner;
public class Scores 
{

	public static void main(String[] args) 
	{
		//declare the variables necessary for the loop
		int number_students = 0;
		boolean counter = true;
		while (counter) //use this loop for data validation
		{
			
			//Ask the user for number of students that they want to input using Scanner
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the number of students: ");
			
			//convert the input to the number of students variable
			number_students = input.nextInt();
			
			//if else statement in order to validate whether the user input the correct values
			if (number_students > 0) 
				counter = false;
			
			else 
				System.out.println("The number of students has to be positive.\n");
		}
		
		//Create variables that will hold the best student and highest score and declare them
		int high_score = 0;
		String best_student = null; 
		
		//Use a for loop in order to ask the user for the name of students and their scores however many times they inputed
		int points = 0; //declare this variable so it can be used in and out the loop
		for (int i=1; i<(number_students+1); i++) 
		{
			//ask the user for the name of the student using Scanner
			Scanner sc = new Scanner(System.in);
			
			//declare the variable name as a string
			String name;
			
			System.out.print("Student " + i + " name: ");
			
			//convert the input given into the name 
			name = sc.nextLine();
			
			boolean counter2 = true; //declare the counter variable and Scanner variable
			Scanner bonus;
			
			//create a loop for data validation
			while (counter2) 
			
			{
			
				//ask the user for the students score using Scanner
				bonus = new Scanner(System.in);
				
				System.out.print("Student " + i + " bonus: ");
				
				//convert the bonus input into the points variable
				 points = bonus.nextInt();
				 
				 //use and if else statement for data validation
				 if (points < 0)
					 System.out.println("Points must be positive.\n");
				 	
				 
				 else
				 	counter2 = false;
				 
			}
			 //use an if statement in order to assign the highest score and name to the holding variable
			 if (points > high_score) 
			 {
				 high_score = points;
				 best_student = name;	 
			 }
			 
		}
		//print out the results and make a space for formatting reasons
		System.out.print("\n");
		System.out.print(best_student + " received the highest score of " + high_score);
	}

}
