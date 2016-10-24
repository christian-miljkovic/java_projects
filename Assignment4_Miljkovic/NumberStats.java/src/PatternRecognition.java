/**
 * This class prints to the screen an increasing sequences of number of maximal length from a given array
 * that contains random elements. 
 * @author Christian Miljkovic
 * @version 02/29/16
 * 
 */

import java.util.Random; 
import java.util.Arrays;
public class PatternRecognition {

	public static void main(String[] args) {
		//create an array to hold the random numbers
		int [] randomArray = new int [15];
		
		//use a for loop in order to fill the array with random numebrs
		for (int i=0; i<randomArray.length; i++) {
			randomArray[i] = (int) (Math.random()*101);
		}
		//print out the random array and use the sequencer method
		System.out.println(Arrays.toString(randomArray)+ "\n"); 
		sequencer(randomArray);
		
	}
/**
 * This method determines the sequence of each number in the randomly generated array
 * @param randomArray: is an array that contains random integers for elements
 * 
 */

	public static void sequencer(int[] randomArray){
		
		//run through the array using a for loop
		for (int i=0; i<randomArray.length-1; i++)
		{	
			
			//determine if the number after the first one is greater than it
			if (randomArray[i]<=randomArray[i+1]) 
			{
				//if so print it
				System.out.print(randomArray[i] + " ");
			}
			
			//if the next number is decreasing 
			else if (randomArray[i]>randomArray[i+1]) 
			{	
				//skip it if its the first
				if (i==0)
					System.out.print("");
				
				//check if the number behind it was bigger since the for loop might've went ahead
				else if (randomArray[i-1]<randomArray[i])
					System.out.print(randomArray[i] + "\n");
				
			}
			
			}
			//due to indexing print the last element if it is bigger than the second to last number
			if (randomArray[randomArray.length-1]>randomArray[randomArray.length-2]) {
				System.out.print(randomArray[randomArray.length-1]);
				
			}
			
		}
	}


