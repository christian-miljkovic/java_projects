package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class BabyNames {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		// Create a container that will hold all the YearName objects
		ArrayList<YearNames> container = new ArrayList<YearNames>();
		int start_date = 0;
		int end_date = 0;
		
		
		// Validate the input from the command line and make sure
		// that there are two arguments if not exit
		if (args.length == 1) {
			System.err.print("Error: Two Strings Required.");
			System.exit(0);
		}
		
		//this is if there is no argument provided
		else if (args.length == 0) {
			start_date = 1880;
			end_date = 2015;
		}
		
		else if(args.length > 2) {
			System.err.print("Error: Two Strings Required Not More.");
			System.exit(0);
		}
		
		//now we check whether the first element is smaller than the second
		else {
			
			start_date = Integer.parseInt(args[0]);
			end_date = Integer.parseInt(args[1]);
			
			// check if the arguments are within the valid range of 1880 to 2015
			if(start_date<1880 || start_date>2015) {
				System.err.print("Error: The start date provided is invalid.");
				System.exit(0);
			}
			
			else if(end_date<1880 || end_date>2015) {
				System.err.print("Error: The end date provided is invalid.");
				System.exit(0);
			}
			
			//check to make sure that the start date is less than the end date
			else if(start_date > end_date) {
				System.err.print("Error: The start date is greater than the end date provided.");
				System.exit(0);	
			}
			
		
		}
		
		//if the arguments pass all of the above tests use the arguments provided
		System.out.println("Loading...");
		System.out.println();

		// Create the Year name objects that will hold all
		// the names and add them to the container created above
		for (int i = start_date; i <= end_date; i++) {

			YearNames year_names = new YearNames(i);
			container.add(year_names);

		}
		
		// this counter is for finding the correct year_names within the
		// container in order
		// to add each name object
		int index = 0;

		// loop through every file and instantiate the Name objects and add them
		// to the YearName class
		for (int i = start_date; i <= end_date; i++) {

			// read all the files
			File file = new File("data/yob" + i + ".txt");

			// create a File object (this can be done even if the file
			// does not exist on disk)

			if (!file.exists()) {
				System.err.println("No such file based on using File class.");
				System.exit(0);
			}

			// create a Scanner object for the file (this fails if the input
			// file does not exist on disk)
			Scanner reader = new Scanner(file);

			while (reader.hasNext()) {

				// get the information from the Scanner and parse it into an
				// array that you
				// will use later in order to create the Name object
				String name_line = reader.nextLine();
				String[] name_fields = name_line.split(",");

				String name = name_fields[0];
				String gender = name_fields[1];
				int count = Integer.parseInt(name_fields[2]);

				// initiate the Name object
				Name n = null;

				// initiate the Name object given the inputs from the array
				try {
					n = new Name(name, gender, count);

				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}

				// add the Name object to the YearName object within the
				// container
				try {
					container.get(index).add(n);

				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}

			}

			index++;
		}
		



		// use this scanner in order to read the input from the user
		Scanner input2;

		// use this in order to stop the do-while loop
		boolean error = true;

		// allow the user to perform the tasks below continuously by using a
		// do-while loop
		do {
			input2 = new Scanner(System.in);
			System.out.print("Enter a name to check popularity or (Q) to exit program: ");

			String answer = input2.nextLine();

			// If the user inputs q or Q quit the program
			if (answer.equalsIgnoreCase("q")) {
				System.out.println("End of Program.");
				error = false;
				break;
			}

			// if the name exists use the histogram method in order to print out
			// the output for
			// each year and do so for each year
			else {
				
				Scanner input3 = new Scanner(System.in);
				System.out.print("Enter the gender: ");
				
				String gender = input3.nextLine();
				
				if((gender.equalsIgnoreCase("f")==false) && (gender.equalsIgnoreCase("m")==false)) {
					System.out.println("That is not a valid gender. \n");
					continue;
				}
				
				// if the container does not have the name within it return false
				if ((containsName(answer,gender,container) == false)) {
					System.out.println("No such name in the dataset. \n");
					continue;
					
				}
				
				else {
					for (int i = 0; i < container.size(); i++) {
						histogram(container.get(i), answer,gender);
					}
				}

			}

		} while (error);

		input2.close();
		

	}

	/**
	 * This method creates a histogram representation of baby name popularity
	 * 
	 * @param year
	 * @param name
	 */
	public static void histogram(YearNames year, String name,String gender) {

		// use this array in order to take the input of the user and make it
		// match the format
		// of the text document names
		char[] temp = new char[name.length()];

		// take out every character so that you can convert it to the correct
		// format
		for (int i = 0; i < name.length(); i++) {
			temp[i] = name.charAt(i);
		}

		String new_name = "";

		// make sure you have the first letter capitalized
		new_name += Character.toUpperCase(temp[0]);

		// create the "cleaned" name of the name provided
		for (int i = 1; i < temp.length; i++) {

			new_name += Character.toLowerCase(temp[i]);
		}

		// find out the percentage and the equivalent bars that need to be
		// printed out based
		// on the amount of babies with the given name
		double percentage = (year.getFractionByName(new_name,gender)) * 100;
		int bars = (int) Math.ceil(percentage * 100);

		// format the output as required
		System.out.printf("%d (%.4f): ", year.getYear(), percentage);

		if (bars != 0) {
			for (int i = 0; i < bars; i++) {
				System.out.print(" | ");
			}
			System.out.println();
		}

		else
			System.out.println();

	}

	/**
	 * This method checks whether the baby name is located within the container
	 * that holds each YearName object
	 * 
	 * @param name2
	 * @param container
	 * @return true if there is a baby name within the container and false if
	 *         not
	 */
	public static boolean containsName(String name, String gender, ArrayList<YearNames> container) {
		
		Name n = new Name(name,gender,1);
		
		// loop through each element within the container
		for (int i = 0; i < container.size(); i++) {
			
			if(container.get(i).containsName(n)==true)
				return true;
		}

		return false;

	}
	
	
	
	

}
