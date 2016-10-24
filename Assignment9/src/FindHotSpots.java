/**
 * This class takes the user input (a valid NYC zip code) 
 * and returns the closest 5 hotspots based upon the 
 * distance using the longitude and latitude of the zip code area
 * and the hotspot location. The program then returns the location, 
 * type, and city in which the hotspot is located.
 * @author christianmiljkovic
 * @version 1.0
 * @date 05/05/16
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FindHotSpots 
{
	public static void main(String[] args) throws Exception 
	{
		

		//create a new File in order to hold the input		
		java.io.File file = new java.io.File("zip_codes_NYC.csv");
		
		//check if the file exists
		if (!file.exists()) 
		{
			System.err.println("No such file pased on path provided.");
			System.err.println("You tried to open" + file);
		}
		
		//use a scanner object to read the file and check whether the file 
		//is still there
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) 
		{
			System.err.println("No such file.");
			System.exit(0);
		}
		
		//create the ZipCode objects from the CSV files
		
		
		/*use a ArrayList to hold the ZipCode objects, another for
		 the lon and lat of the zip code. Use an arraylist of arraylist
		 in order to organize each set of lon and lat's
		 */
		ArrayList<ZipCode> data = new ArrayList<ZipCode>();
		ArrayList<Double> intZipCode = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> holder = new ArrayList<ArrayList<Double>>();
		
		//use a while loop in order to parse each line within the csv file
		while (input.hasNextLine() != false) 
		{
			
			String textLine = input.nextLine();
			
			//creates each line from the csv file
			ArrayList<String> thisLinesZipCode = new ArrayList<String>();
			
			//make sure that the splitting of the csv file is handled if there are invalid lines
			// and to make sure that 
			try {
				thisLinesZipCode = split(textLine);
				intZipCode = integerConverter(thisLinesZipCode);
				holder.add(intZipCode);
				
				
			} catch (Exception ex) {
				System.out.println("This line is invalid");
			}
			
			
			
		}

		input.close();
		
		//this converts the arraylists into zipcode objects then places them 
		//back into the data arraylist for storage
		
		//create the ZipCode object and then put that into the arraylist
		data = toZipObject(holder, data);
		
		
		
		
		
		
		
		
		
		// creation of the HotSpot Object
		
		java.io.File file2 = new java.io.File("NYC_Wi-Fi_Hotspot_Locations.csv");
		
		
		//use a scanner object to read the file and check whether the file 
		//is still there
		Scanner input2 = null;
		try{
			input2 = new Scanner(file2);
		} catch (FileNotFoundException e) 
		{
			System.err.println("No such file.");
			System.exit(0);
		}
		
		
		//create the HotSpot objects from the CSV file
		
		//holds the HotSpot Objects
		ArrayList<HotSpot> data2 = new ArrayList<HotSpot>();
		
		//the arraylists for the strings of the hotspot objects
		//the arraylist of arraylist string helps orgranize each objects string data fields
		ArrayList<String> strHolder = new ArrayList<String>();
		ArrayList<ArrayList<String>> strHolder2 = new ArrayList<ArrayList<String>>();
		
		//the arraylists for the numbers of the hotstop objects
		//the arraylist of arraylist double helps organize each objects lon and lat
		ArrayList<Double> intHotSpot = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> intHolder = new ArrayList<ArrayList<Double>>();
		

		
		//use a while loop in order to parse each line within the csv file
		while (input2.hasNextLine() != false) 
		{
			
			String textLine2 = input2.nextLine();
			
			//creates each line from the csv file
			ArrayList<String> thisLinesHotSpot = new ArrayList<String>();
			
			try {
			//creates the string holder for the object later
			thisLinesHotSpot = split(textLine2);
			strHolder = strConverter(thisLinesHotSpot);
			strHolder2.add(strHolder);
			
			
			
			//creates the double holder for the object later
			intHotSpot = integerConverter(thisLinesHotSpot);
			intHolder.add(intHotSpot);
			
			}catch (Exception ex) {
				//
			}
			

		}
		
		input2.close();
		
		//create the object then add it to the Hotspot object arraylist
		data2 = toHotObject(intHolder, strHolder2,data2); 
		
		
		
		
		
		
		
		
		
		
		//users interface 
		boolean cont = true;
		
		//use a do loop incase the user wants to see another 5 hotspots
		do {
		
			//read the input from the user
			Scanner reader = new Scanner(System.in);
			System.out.print("Enter a NYC Zip Code for 5 Hot Spots Near You (between 10001 and 11697): ");
			
			//check to make sure that the user inputs the correct zip code
			try {
			int user_zipCode = reader.nextInt();
			
			//throw an InvalidZipCodeException if the user did not input a valid one
			if (user_zipCode < 10001 || user_zipCode > 11697) 
			{
				throw new InvalidZipCodeException(user_zipCode);
			}
		
			//holder index that will help find the correspondnig zip code 
			//within the arraylist that holds all the zip codes
			int zipCodeIndex = 0;
			
			//find that zip codes lat and lon within the zip code holder
			for (int i = 0; i < data.size(); i++ ) 
			{
				//if the zipcodes match set the index to this 
				if (data.get(i).zipCode == user_zipCode)
					zipCodeIndex=i;
			}
			
			//set the sorted list of HotSpots based on minimum distance to the arraylist
			ArrayList<HotSpot> sortedList = ArrayListSort(data2, data.get(zipCodeIndex).latitude,data.get(zipCodeIndex).longitude );
			
			//print out the information of each hotspot
			for (int i=0; i < sortedList.size(); i++) 
			{
				System.out.println("The Hot Spot is: " + sortedList.get(i).type);
				System.out.println("It's address is: " + sortedList.get(i).location);
				System.out.println("The City it is located in: " + sortedList.get(i).city+ "\n");
				
			}
			} catch (InputMismatchException ex) {
				System.out.println("That is not a valid zip code \n");
			} catch(InvalidZipCodeException ex) {
				System.out.println("Invalid zip code \n");
			}
			
			//read the users input to determine if they want to see 5 more hotspots
			Scanner close_input = new Scanner(System.in);
			
			
			boolean validate = true;
		
		//use a while loop in order to validate the users input
		while (validate) 
		{
			
			System.out.println("Would you like to search another 5 Hot Spots?");
			String close = close_input.nextLine();
			
			//if the answer is valid break out of the while loop 
			//if yes continue the do loop
			if (close.toLowerCase().equals("no") == true)
			{
				cont = false; 
				break;
				
			}
			
			//if the answer is valid break out of the while loop
			//if no get out of the do loop
			else if (close.toLowerCase().equals("yes")==true)
			{
				cont = true;
				break;
			}
			
			//continue the while loop if the input is invalid
			else {
				System.out.println("Invalid input");
				validate = true;
				System.out.println("\n");
			}
			
		}	
		
		System.out.print("\n");
		
		} while(cont);
		
	}

	
	
	
	
	
	
	
	
	/**
	 * Splits a given line according to commas (commas within entries are ignored)
	 * @param texLine line of text to be parsed
	 * @return an ArrayList object containing all individual entries/tokens
	 * found on the line
	 */
	
	public static ArrayList<String> split(String textLine) 
	{
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer();
		char nextChar;
		boolean insideQuotes = false;
		
		for (int i = 0; i < lineLength; i++) 
		{
			nextChar = textLine.charAt(i);
			
			//add character to the current entry 
			if (nextChar != ',' && nextChar != '"') 
			{
				nextWord.append(nextChar);
			}
			
			else if (nextChar == '"') 
			{
				if (insideQuotes) 
				{
					insideQuotes = false;
				}
				else 
				{
					insideQuotes = true;
				}
			}
			
			//found comma inside double quotes, just add it to the string
			else if (nextChar == ',' && insideQuotes) {
				nextWord.append(nextChar);
			}
			
			//end of the current entry reached, add it to the list of entries
			//and reset the nextWord to empty string
			else if (nextChar==',' && !insideQuotes) {
				//trim the white space before adding to the list
				entries.add(nextWord.toString().trim());
				
				nextWord = new StringBuffer();
			}
			
			else {
				System.err.println("This should never be printed. \n");
			}
		}
		//add the last word
		//trim the white space before adding to the list
		entries.add(nextWord.toString().trim());
		
		return entries;
	}
	/**
	 * Computes the distance between two locations given the longitude and latitude
	 * of each location
	 * @param lat1: latitude of first location
	 * @param lon1: longitude of first location
	 * @param lat2: latitude of second location
	 * @param lon2: longitude of second location
	 * @return the distance between two locations
	 */
	static double haversine(double lat1, double lon1, double lat2, double lon2) {
		final double R = 6372.8; //in kilometers
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1= Math.toRadians(lat1);
		lat2= Math.toRadians(lat2);
		
		double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon/2), 2) 
			* Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}
	
	/**
	 * This method converts an ArrayList<String> into an ArrayList<Integer>
	 * @param stringArray: an ArrayList<String>
	 * @return: conversion which is an ArrayList<Integer>
	 */
	public static ArrayList<Double> integerConverter(ArrayList<String> stringArray) 
	{
		ArrayList<Double> conversion = new ArrayList<Double>();


		for (int i=0; i < stringArray.size(); i++) 
		{
			
			try {
			conversion.add(Double.parseDouble(stringArray.get(i)));

			}catch (NumberFormatException ex) {
				
			}
	
		}
		
		return conversion;

	}
	

	/**
	 * This method takes an arraylist that holds another arraylist of longitudes and latitudes
	 * and convert these into valid zipCode objects
	 * @param holder is a ArrayList<ArrayList<Double>> that holds the lon and lat of each object
	 * @param data: is the ArrayList<ZipCode> that will hold the newly created objects
	 * @return: zipcode is the newly populated arraylist of ZipCode objects
	 */
	public static ArrayList<ZipCode> toZipObject(ArrayList<ArrayList<Double>> holder,  
			ArrayList<ZipCode> data) 
	{

		//use a for loop in order to delete the empty array that comes from the title
		for (int i=0; i < holder.size(); i++) 
		{
			if(holder.get(i).size() == 0)
				holder.remove(i);
		}

			//run throught the loop in order to take out each num and put it in the 
			//zipCode constructor
			for (int i=0; i < holder.size(); i++) 
			{
				//make sure that the input coming in from the file is valid
				try {
					int zipCode=0;
					double latitude=0;
					double longitude=0;
				
					//within the second arraylist is where the doubles/data fields
					// are located therefore plug those into the constructor
					for (int j=0; j < holder.get(i).size(); j++) 
					{
						//use if elif statements to get the correct input from the arraylist
						if (j==0)
							zipCode= (int) Math.round(holder.get(i).get(j));
						
						else if (j==1)
							latitude=holder.get(i).get(j);
						
						else
							longitude=holder.get(i).get(j);
					}
	
					//create the zipCode object then store it
					ZipCode zipObj = new ZipCode(zipCode, latitude, longitude);
					data.add(zipObj);
	
					
				}catch (IllegalArgumentException ex) {
					//System.err.println("Illegal");
					
				} catch (ArrayIndexOutOfBoundsException ex) {
					//System.err.println("Array");
				
				}
			
			
			} 
			
		
		return data;
	}
	
	/**
	 * This method takes the arraylist that holds each textline from the csv file
	 * and takes out the required strings for the HotSpot object then appropriately organizes them.
	 * @param stringArray: an arraylist of the textline from the csv file
	 * @return: an array list that contains the correct strings required for the HotSpot object
	 */
	public static ArrayList<String> strConverter(ArrayList<String> stringArray) 
	{
		//create the holder arraylist
		ArrayList<String> conversion = new ArrayList<String>();
		
		
		//use a try catch block in order to prevent any incorrect input that may come from an
		//invalid csv file
		try {
			
		//make sure that the data point you are taking is not empty or is
		// not under the correct column because of missing numbers
		if (stringArray.size() == 15) 
		{
			
			for(int i=0; i < stringArray.size(); i++)
			{
				//use an if elif statement in order to get rid of the categories on the first line
				if(i==2) 
				{
					if (!(stringArray.get(i).equals("Type")) && stringArray.get(i).length() > 0)
							conversion.add(stringArray.get(i));
				}
				
				else if (i==5) 
				{
					if (!(stringArray.get(i).equals("Location")) && stringArray.get(i).length() > 0)
						conversion.add(stringArray.get(i));
				
				}
				else if (i==12) 
				{
					if (!(stringArray.get(i).equals("City")) && stringArray.get(i).length() > 0)
						conversion.add(stringArray.get(i));
					
				}
			}
		}

		
		}catch (IllegalArgumentException ex) 
		{
			System.err.print("Invalid input");
		}
		
		return conversion;
	}
	
	
	/**
	 * This method takes the arraylist that holds the longitudes and latitudes for the hotspot objects
	 * and the arraylist that holds the strings for the hotspot obejcts and combines them and creates the
	 * hotspot object.
	 * @param intHolder: an arraylist that holds all the longitudes and latitudes that will go in the hotspot object
	 * @param strHolder2: an arraylist that holds all the string variables that will go in the hotspot object
	 * @param data2
	 * @return: an arraylist that holds all the hotspot objects
	 */
	public static ArrayList<HotSpot> toHotObject(ArrayList<ArrayList<Double>> intHolder, 
			ArrayList<ArrayList<String>> strHolder2, ArrayList<HotSpot> data2) 
	{
		
		
		
		//delete the empty arraylists<double> 
		for (int i=0; i < intHolder.size(); i++) 
		{
			if(intHolder.get(i).size() == 0)
				intHolder.remove(i);
		}
		
		//delete the empty arraylists<string>
		for (int i=0; i < strHolder2.size(); i++)
		{
			if(strHolder2.get(i).size() == 0)
				strHolder2.remove(i);
		}
		
		//for the while loop
		int count = 0;
		
		//use a while loop so that you can encapsulate the variables that come out of each for loop
		//and then put them into the hotspot constructor
		while(count < 1) 
		{
			//use an array of each datafield in order to hold the datafield for when you put 
			//put them back in the construcot
			double[] latHolder = new double[intHolder.size()];
			double[] lonHolder = new double[intHolder.size()];
			String[] typeHolder = new String[intHolder.size()];
			String[] locationHolder = new String[intHolder.size()];
			String[] cityHolder = new String[intHolder.size()];
			
			
			//get the correct latitude and longitude from the double arraylist
			for (int i=0; i < intHolder.size(); i++) 
			{
				
				double latitude=0;
				double longitude=0;
				
				//use a for loop to go within the arraylist an retrieve each data field
				for (int j=0; j < intHolder.get(i).size(); j++)
				{
					//use an if elif statement in order to check that the longitudes and latitudes are valid
					if (intHolder.get(i).get(j) >= 40.5095311239 && intHolder.get(i).get(j) <= 40.9037227771)
						latitude = intHolder.get(i).get(j);
					
					if (intHolder.get(i).get(j) >= -74.2441067083 && intHolder.get(i).get(j) <= -73.7148377572)
						longitude = intHolder.get(i).get(j);
					
				}
				//place the lat and lon into the holding arrays
				latHolder[i] = latitude;
				lonHolder[i] = longitude;
				
				
			}
				
			//get the str information from the str arraylist
			
			for(int i=0; i < strHolder2.size(); i++) 
			{
				String type="";
				String location="";
				String city="";
				
				//use a for loop to go within the arraylist an retrieve each data field
				for (int j=0; j < strHolder2.get(i).size(); j++) 
				{
					//use if elif statement to retrieve from the correct location in 
					//the array list
					if (j==0)
						type=strHolder2.get(i).get(j);
					
					if (j==1)
						location=strHolder2.get(i).get(j);
					
					if (j==2)
						city=strHolder2.get(i).get(j);
					
				}
				
				//place the data fields into their respective holding variables
				typeHolder[i] = type;
				locationHolder[i] = location;
				cityHolder[i] = city;
				
			}
			
			//loop  through each holding array and plug in the value into the hotspot constructor
			for (int i=0; i < typeHolder.length; i++) 
			{
				HotSpot hotObj = new HotSpot(typeHolder[i], locationHolder[i], 
						cityHolder[i], latHolder[i], lonHolder[i]);
				
				//check to make sure it is a valid object
				if ((hotObj.city instanceof String) || (hotObj.type instanceof String) || 
						(hotObj.location instanceof String))
				{
					//add the newly craeted object to the holding arraylist
					data2.add(hotObj);
				}
				
					
			}
			
			
			count++;
			}
		return data2;
	}
	
	/**
	 * This method goes through an ArrayList of hotspot objects and returns a list of 5 hotpsots within
	 * an array list with the shortest distance to the provided longitude and latitude. Then those hotspots are removed.
	 * @param arrayList: unsorted arraylist of hotspot obejcts
	 * @param latitude: the latitude you want to compare each object to
	 * @param longitude: the longitude you want to compare each object to
	 * @return: the array list that contains 5 hotspot objects with the shortest distance from the provided lon and lat
	 */
	public static ArrayList<HotSpot> ArrayListSort(ArrayList<HotSpot> arrayList, double latitude, double longitude)
	{
			
			//create a holding variable
			ArrayList<HotSpot> toReturn = new ArrayList<HotSpot>();
			
			//use this to count 5 times
			int count = 0;
			
			//use a while loop in order to repeat the process 5 times
			while(count < 5) 
			{
				//default that you compare other hotspots too
				HotSpot min = arrayList.get(0);
				
				//default distance that you compare other distances to
				double currentDistance = haversine(latitude, longitude, 
						arrayList.get(0).latitude, arrayList.get(0).longitude);
				
				//index of default
				int index = 0;
				
				//run through the arraylist in order to find the min
				for (int i = 1; i < arrayList.size(); i++) 
				{
					//find the distance of each hotspot 
					double distance = haversine(latitude, longitude, 
							arrayList.get(i).latitude, arrayList.get(i).longitude);
					
					//if the distance is smaller than the previous change the new one
					//to the default
					if (distance < currentDistance) 
					{
						index=i;
						currentDistance = distance;
						min = arrayList.get(i);
					}
				
				
			}
				//add the hotspot with the smallest distance and remove it from the array list
				//after each while loop run through
				toReturn.add(min);
				arrayList.remove(arrayList.get(index));
				count++;
			}
			
			return toReturn;
		
	}

}

	
	

