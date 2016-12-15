package project5;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class PopularWords {

	//use a hash map as a data field in order to hold in the words from the text file
	static HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
	
	
	public static void main(String[] args) {
		
		
		//check to make sure there are enough commands input
		if(args.length < 2) {
			System.err.println("Not enough Commands");
			System.exit(0);
		}
		
		//hold the values for each argument
		String str_file = args[0]; 
		String command = args[1];
		
		//if there is the full amount of commands then set the k = to the argument
		if(args.length==3) {
			int k = Integer.parseInt(args[2]);
		}

		//create a file object
		File file = new File(str_file);
		
		//check if the file exists
		if (!file.exists()) {
			System.err.println("No such file based on using File class.");
			System.exit(0);
		}
		
		//try reading in the data from the text file
		try {
			Scanner input = new Scanner(file);
			//use the delimiter method in order to determine when you have a word
        	input.useDelimiter("(\\s+[\\-_']+)|([\\-_']+\\s+)|(\\s*[^a-zA-Z\\-_']+\\s*)|([\\-_'][\\-_']+)");
        	
        	//loop through the text using a while loop and add the words to the hashmap
        	while(input.hasNext()) {
        		//check to see if the word has a length larger than 1
        		String word = input.next();
        		
        		if(w)
        		
        		
        	}
        	
        	
        	
        	
        	
		} catch {
			
		}
		
		
		
		
		
		
	}
}


/**
 * This class creates a Comparator for comparing words
 * @author christianmiljkovic
 *
 */
class ComparatorWord implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}

/**
 * This class creates a Comparator for comparing the frequency of words in a hash map
 * @author christianmiljkovic
 *
 */
class ComparatorFrequency implements Comparator<String> {
	
	//data field for the class is the hash map
	HashMap<String, Integer> map;
	
	//this is the constructor for the class
	public ComparatorFrequency(HashMap<String, Integer> map){
		this.map = map;
	}
	
	@Override
	/**
	 * This method finds the object within the hash map and then uses the 
	 * compare method below in order to compare the frequencies
	 */
	public int compare(String o1, String o2) {
		return compare(map.get(o1), map.get(o2));
	}
	
	
	/**
	 * Since we are looking at the frequency we are comparing the integers of the object
	 * that is returned from the hash map
	 * @param o1 an integer object
	 * @param o2 another integer object to be compare to o1
	 * @return
	 */
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}

