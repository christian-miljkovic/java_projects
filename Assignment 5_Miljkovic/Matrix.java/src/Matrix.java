/**
 * This class prompts the user to input the number of rows and columns in a matrix which is then populated 
 * with random integers. Then, the user has the option of performing various operations on the matrix such as a flip.
 * @author Christian Miljkovic
 * @version 03/22/16
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Matrix {

	public static void main(String[] args) 
	{
		
		int row;
		int column;
		
		//use a do-while loop in order to validate the user input
		do 
		{
		//prompt the user for the number of rows in the matrix
		Scanner input = new Scanner(System.in);
		System.out.print("How many number of rows in your matrix (1-5)? ");
		row = input.nextInt();
		System.out.println();
		} while(row<1 | row>5);
		
		do 
		{
		//prompt the user for the number of columns in the matrix
		Scanner input2 = new Scanner(System.in);
		System.out.print("How manny number of columns in your matrix (1-5)? ");
		column = input2.nextInt();
		System.out.println();
		} while(column<1 | column>5);
		
		int[][] matrix = new int[row][column];
		
		// fill the matrix with random numbers ranging from -10 to 10
		for (int i=0; i<matrix.length; i++)
		{
			for (int j=0; j<matrix[0].length; j++) 
			{
				int num = (int)(-11 + Math.random() * 22);
				matrix[i][j] = num;
				
			}
		}
		printMatrix(matrix);
		System.out.println();
		
		String answer;
		Scanner input3 = new Scanner(System.in);
		
		do 
		{
		System.out.println();
		System.out.print("\n" + "H horizontal flip - each row is reversed \n" + "\n"
				+ "V vertical flip - each column is reversed \n" + "\n" +
				"T transpose - rows become columns (and vice versa) \n" + "\n" +
				"R rowMax - find largest value in each row \n" + "\n" + 
				"C columnSum - find sum of the values in each column \n" + "\n"+ 
				"Q quit \n" + "\n" + "Choose an option: ");
		answer = input3.nextLine();
		
			if (answer.equals("H") | answer.equals("h")) 
			{
				printMatrix(horizontalFlip(matrix));
			}
			
			else if (answer.equals("V") | answer.equals("v")) 
			{
				printMatrix(verticalFlip(matrix));
			}
			
			else if (answer.equals("T") | answer.equals("t")) 
			{
				printMatrix(transpose(matrix));
			}
			
			else if (answer.equals("R") | answer.equals("r")) 
			{
				System.out.print(Arrays.toString(rowMax(matrix)));
			}
			
			else if (answer.equals("C") | answer.equals("c")) 
			{
				System.out.print(Arrays.toString(columnSum(matrix)));
			}
			
			else if (answer.equals("Q") | answer.equals("q")) 
			{
				System.exit(0);
			}
			
			else 
			{ 
				System.out.print("Error: incorrect input.");
			}
		} while (!answer.equals("Q") | !answer.equals("q"));
		
		
		
		
		
		System.out.println();
		
	}
/**
 * This method takes a 2D matrix and prints it out
 * @param matrix: is a 2D array that contains random integers
 */
	public static void printMatrix (int [][] matrix) 
	{
		//run through the matrix and use printf in order to format the output
		for (int row=0; row < matrix.length; row++) 
		{
			for (int col=0; col < matrix[row].length; col++) 
			{
				System.out.printf("%4d ",  matrix[row][col]);
			}
			System.out.println();
		}
	}
/**
 * This method takes a 2D matrix and horizontally flips it	
 * @param matrix: is a 2D array that contains random integers
 * @return: newMatrix that is a horizontally flipped version of matrix
 */
	public static int[][] horizontalFlip(int[][] matrix)
	{
		//create a new matrix in order to maintain the original
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		//run through the matrix using for loops
		for (int row=0; row < newMatrix.length; row++) 
		{
			for (int col=0; col < newMatrix[row].length; col++) 
			{
				//for the column start from the last one and work backwards
				newMatrix[row][col]= matrix[row][matrix[0].length-col-1];
			}
		}	
		return newMatrix;
	} 
/**
 * This method takes a 2D matrix and vertically flips it
 * @param matrix: is a 2D array that contains random integers 
 * @return: newMatrix that is a vertically flipped version of matrix
 */
	public static int[][] verticalFlip(int[][] matrix) 
	{
		//create a new matrix in order to maintain the original
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		//run through the matrix using for loops
		for (int row=0; row < newMatrix.length; row++) 
		{
			for (int col=0; col < newMatrix[row].length; col++) 
			{
				//for the row start from the last one and work backwards
				newMatrix[row][col]= matrix[matrix.length-row-1][col];
			}
		}	
		return newMatrix;
	}
/**
 * This method takes a 2D matrix and switches the rows with the columns	
 * @param matrix: is a 2D array that contains random integers
 * @return: newMatrix whose columns are rows of the matrix passed as a parameter
 */
	public static int[][] transpose(int[][] matrix) 
	{
		//create a new matrix in order to maintain the original
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		//run through the matrix using for loops
		for (int row=0; row < matrix.length; row++) 
		{
			for (int col=0; col < matrix[0].length; col++) 
			{
				//switch the rows with the columns
				newMatrix[col][row] = matrix[row][col];
			}
		}
		return newMatrix;
	}
/**
 * This method runs through each row in a matrix and determines which integer is the largest.	
 * @param matrix: a 2D array that contains random integers
 * @return: newMatrix which is a 1D array that contains the largest integers in each row
 */
	public static int[] rowMax(int[][] matrix) 
	{
		// create an array to hold the max values
		int[] newMatrix = new int[matrix.length];
		//create two for loops to run through each row then column
		for (int row=0; row < matrix.length; row++) 
		{
			//holder variable in order to compare integers
			int maxNum=matrix[row][0];
			for (int col=0; col < matrix[0].length; col++) 
			{
				//use an if statement in order to determine which number is the largest 
				if (matrix[row][col]>maxNum)
				{
					maxNum=matrix[row][col];
				}
			newMatrix[row] = maxNum;
			
			}
		}
		return newMatrix;
	}
/**
 * This method finds the sum of all the integers in each column of the matrix passed through.	
 * @param matrix: a 2D array that contains random integers
 * @return:  newMatrix which is a 1D array that contains the sum of each column 
 */
	public static int[] columnSum(int[][] matrix) 
	{
		// create an array to hold the sums of each column
		int[] newMatrix = new int[matrix[0].length];
		//create for loops to run through each column
		for (int col=0; col < matrix[0].length; col++) 
		{
			int colSum=0;
			for (int row=0; row < matrix.length; row++)
			{
				colSum += matrix[row][col];
			}
			newMatrix[col]= colSum;
		}
		return newMatrix;
		
	}

}
