/* Christian Miljkovic
 * 02/10/16
 * This program simulates the rolling of two 4 sided dices 1000 times and then 
 *  takes the sums of the two dice and adds them together in order to display
 *  how many times 2 - 8 was rolled
*/
public class TwoDice {

	public static void main(String[] args) {

		//declare and create holding variables for the sums of the two dice
		//starting from 2 to 8 since we are using a 4 sided die
		int twos= 0;
		int threes = 0;
		int fours = 0;
		int fives= 0;
		int sixes = 0;
		int sevens = 0;
		int eights = 0;
		
		//create rolls variable as a termination variable for the for loop
		int rolls = 1000;
		int dice1; //use this variable to hold the value of the Math.random() output for the first die
		int dice2; //use this variable to hold the value of the Math.random() output for the second die
		
		//create a for loop to simulate rolling two dice 1000 times
		for (int i = 0; i<1000; i++) {
			dice1 = (int)(Math.random() * 4 +1); //do *4 +1 for Math.random in order to get a range from 1 to 4 for the first die
			dice2= (int)(Math.random() * 4 +1); //do *4 +1 for Math.random in order to get a range from 1 to 4 for the second die
			
			
			//create if elif statements that use the addition of the two random outputs for each die as the condition statement
			//and add to the previous holding variables if the sum adds up to the corresponding variable 
			// for example if dice1 + dice2 = 3 add 1 to the variable threes
			if (dice1 + dice2 == 2)
				twos = twos + 1;
			else if (dice1 + dice2 ==3)
				threes = threes + 1;
			else if (dice1 + dice2 ==4)
				fours = fours + 1;
			else if (dice1 + dice2 ==5)
				fives = fives + 1;
			else if (dice1 + dice2 ==6)
				sixes = sixes + 1;
			else if (dice1 + dice2 ==7)
				sevens = sevens + 1;
			else if (dice1 + dice2 ==8)
				eights = eights + 1;
				
				
		}
		//print out the input of the rolls using the same formatting from Dice.java but instead
		//go start from twos and go to eights
		System.out.printf("2 was rolled %5.2f%% " +
				"of times\n", (float)(twos) / rolls * 100);
		System.out.printf("3 was rolled %5.2f%% " +
				"of times\n", (float)(threes) / rolls * 100);
		System.out.printf("4 was rolled %5.2f%% " +
				"of times\n", (float)(fours) / rolls * 100);
		System.out.printf("5 was rolled %5.2f%% " +
				"of times\n", (float)(fives) / rolls * 100);
		System.out.printf("6 was rolled %5.2f%% " +
				"of times\n", (float)(sixes) / rolls * 100);
		System.out.printf("7 was rolled %5.2f%% " +
				"of times\n", (float)(sevens) / rolls * 100);
		System.out.printf("8 was rolled %5.2f%% " +
				"of times\n", (float)(eights) / rolls * 100);
		
		
	}

}
