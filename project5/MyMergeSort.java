package project5;

import java.util.Arrays;
import java.util.Comparator;

public class MyMergeSort {
	
	
	/**
	 * This is the wrapper class for the merge sort algorithm
	 */
	public static void sort(Object[] list, Comparator<String> comparator) {
		
		
		//now start the actual merge sort method
		mergesort((String[]) list,0,list.length-1,comparator);
	}
	
	/**
	 * This is the actual method that implements a merge sort on a generic array
	 * @param first index of the list
	 * @param last index of the list
	 * @param comparator is how you will compare each object
	 */
	private static void mergesort(String[] original_array, 
			int first, int last, Comparator<String> comparator) {
		
		
		if (last > first) {
			

			//find the middle index
			int middle_index = (last+first)/2;
			
			
			//recursively sort the left side of the array
			mergesort(original_array,first,middle_index,comparator);
			
			//recursively sort the right side of the array
			mergesort(original_array,(middle_index+1),last,comparator);
			
			
			//merge the arrays once you've gotten them to singletons
			merge(original_array,first,(middle_index+1),last,comparator);
		
		}

	}
	
	/**
	 * This method merges two arrays together and sorts them
	 * @param first index of the array
	 * @param middle index of the array
	 * @param last index of the array
	 * @param comparator the way in which we compare the objects
	 */
	private static void merge(String[] original_array,
			int first, int middle, int last, Comparator<String> comparator) {

		int number_elements = (last - first + 1);
		String[] merged_array = new String[number_elements];
		
		//create variables so that you can change the indices that being compared while
		//being able to still maintain the while loop limits
		int left_end = middle-1; 
		int first_left = first;
		int first_right = middle;
		//use an index variable in order to place the objects in the correct location
		int index = 0; 
		
		System.out.println(merged_array.length);
		System.out.println(first);
		System.out.println(last);
		System.out.println(index);
		System.out.println(Arrays.toString(merged_array));
		
		//sort the array using a while loop 
		while((first_left <= left_end ) && (first_right <= last)) {
			
			//check whether the two objects are in order
			if(comparator.compare(original_array[first_left], original_array[first_right]) <= 0) {
				//if this is the case then we know they are in order
				merged_array[index++] = original_array[first_left++]; 
			}
			//this is the case for when it is not in order
			else {
				merged_array[index++] = original_array[first_right++];

			}
			
		}
		

		
		
		
		while(first_left <= left_end) {
			merged_array[index++] = original_array[first_left++];
		}
		
		while(first_right <= last) {
			merged_array[index++] = original_array[first_right++];
		}
		index = first;
		
		//when done with comparing the elements in the array copy over
		for(int i=0; i < merged_array.length; i++) {
			original_array[index] = merged_array[i];
			index++;
		}
		
	}
	
	
}
