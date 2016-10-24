/**
 * This class represents several methods where one calculates the mode, one calculates the mean,
 * and one calculates the median. Furthermore, these methods have arrays of size 100, 1000, and 10000
 * passed through them with the elements containing ints in the range of -100 and 100.
 * 
 * @author Christian Miljkovic
 * @version 02/29/16
 */


import java.util.Random;
import java.util.Arrays;
public class StatCalc {

	public static void main(String[] args) {
		//create an array with 100 elements
		int[] randomArray = new int [100];
		
		//use a for loop to populate the array with random numbers
		for (int i=0; i<100; i++){
			int randomNum = (int) (-100+ Math.random()*201);
				
			randomArray[i] = randomNum;

		}
		//repeat the same as above except use an array and for loop that run 1000 times
		int[] randomArray2 = new int [1000];
		for (int i=0; i<1000; i++){
			int randomNum = (int) (-100+ Math.random()*201);
				
			randomArray2[i] = randomNum;

		}
		//repeat the same as above except use an array and for loop that run 10000 times
		int[] randomArray3 = new int [10000];
		for (int i=0; i<10000; i++){
			int randomNum = (int) (-100+ Math.random()*201);
				
			randomArray3[i] = randomNum;

		}
		//sort the arrays then print out the statistics for them using the methods
		java.util.Arrays.sort(randomArray);
		System.out.println("Statistics for 100 element array:");
		System.out.println("Mean: " + mean(randomArray));
		System.out.println("Median: " + median(randomArray));
		System.out.println("Mode: " + mode(randomArray) + "\n");
		
		//repeat as the above
		java.util.Arrays.sort(randomArray2);
		System.out.println("Statistics for 1,000 element array:");
		System.out.println("Mean: " + mean(randomArray2));
		System.out.println("Median: " + median(randomArray2));
		System.out.println("Mode: " + mode(randomArray2) + "\n");
		
		//repeat as above
		java.util.Arrays.sort(randomArray3);
		System.out.println("Statistics for 10,000 element array:");
		System.out.println("Mean: " + mean(randomArray3));
		System.out.println("Median: " + median(randomArray3));
		System.out.println("Mode: " + mode(randomArray3));
	}
/**
 * This method calculates the mean of an array passed through it.
 * @param an array of integers
 * @return returns the mean of all the numbers in the array.
 */
	public static int mean(int[] list) {
		//collect the sum of the entire array 
		int sum = 0;
		for (int i=0; i<list.length-1; i++) {
			sum+=list[i];
		}
		//divide the sum of the array by the total number of elements
		int mean = sum/(list.length);
		return mean;
	}

/**
 * This method calculates the median of an array passed through it.
 * @param an array of integers
 * @return returns the median of the array passed through the method.
 */
	public static int median(int[] list) {
		//find the median by dividing the total in half twice add and to one of those halves 
		//add one then divide the sum of the two by two
		int median = (list[(list.length-1)/2] + list[((list.length-1)/2)+1])/2;
		return median;
	}
/**
 * This method calculates the mode of an array passed through it.
 * @param an array of integers.
 * @return returns the mode of the array passed through the method.
 */

	public static int mode(int[] list){
		//use these variables to hold the current mode and index of that mode
		int currentMode = list[0];
		int currentModeIndex = 0;
		//use this to determine what number occurs the most
		int count = 0; 
		int[] checkList = new int[list.length];
		//use a mirrored array in order to check to see what number occurs multiple times
		System.arraycopy(list, 0, checkList, 0, list.length);
		
		//run through each array 
		for (int i=0; i<list.length; i++){
			int currentCount = 0;
			for (int j=0; j<list.length; j++){
				
				//if there is a matching number add to its count
				if (list[i]==checkList[j])
					currentCount+=1;
				//if the count is greater than the previous one this is the new mode index
				if (currentCount>count)
					currentModeIndex=i;
				

			}
			// if the count is greater than the previous one this is the new mode number
			if (currentCount>count){
				count=currentCount;
				currentMode = list[currentModeIndex];
			}
		}
		return currentMode;
	}
}
