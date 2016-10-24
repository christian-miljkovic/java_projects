/**
 * This class uses various methods to merge together two sorted lists
 * 
 * @author Christian Miljkovic
 * @version 02/29/16
 */
import java.util.Scanner;
public class Merger {
	
/**
 * Merges two sorted lists together
 * @param list1 that you want merged
 * @param list2 that you want merged with list1
 * @return returns an array that contains list1 and list2 merged in increasing order
 */
	public static int[] merge(int[] list1, int[] list2) {
		
		//create a merged list that is the size of the length of list1 and list2
		int[] mergeList = new int[list1.length+list2.length];
		
		// create holding variables so that you can compare elements from list1 and list2
		int index1 = 0;
		int index2 = 0;
		int i = 0; //create this variable in order to index the elements into the correct spot 
		
		//use a while loop in order to run through the lists
		while (index1<list1.length && index2<list2.length) {
			
			//check if the first element in list1 is smaller than first element in list2
			if (list1[index1]<list2[index2]) {
				//if so add the element to the merged list and change the indexing
				mergeList[i] = list1[index1];
				i += 1;
				index1 += 1;

				}
			
			else {
				//else if the first element in list1 is larger than first element in list2
				mergeList[i] = list2[index2];
				i += 1;
				index2 += 1;	
			}
			// this is if the list1 has all lower numbers than list2
			if (index1==2 && index2==0) {
				while (index2<list2.length) {
					mergeList[i] = list2[index2];
					i += 1;
					index2 += 1;
				}
			}
			// this is if the list2 has all lower numbers than list1
			else if (index1==0 && index2==2) {
				while (index1<list1.length) {
					mergeList[i] = list1[index1];
					i += 1;
					index1 += 1;
				}
			}
			}
		//this is in order to add any extra elements if list1 is smaller than list2
		if (list1.length < list2.length) {
			while (index2<list2.length) {
				mergeList[i] = list2[index2];
				i += 1;
				index2 += 1; 
			}
		}
		//this is in order to add any extra elements if list2 is smaller than list1
		else if (list1.length > list2.length) {
			while (index1<list1.length) {
				mergeList[i] = list1[index1];
				i += 1;
				index1 += 1; 
			}
		}



		

			
		return mergeList;

		
	}
/**
 * checks to see if the list that is passed through is sorted in increasing order
 * @param list that you want to check if it is sorted
 * @return true if the list is sorted in increasing order 
 * return false if the list is not sorted in increasing order
 */
	public static boolean isSorted(int[] list) {
		for (int i=0, j=1; j<list.length; i++, j++) {
			if (list[i]>list[j])
				return false;
		}

		
		return true;
	}

	
public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	System.out.print("What is the length of the first list: ");
	int length1 = input.nextInt();

	
	Scanner input2 = new Scanner(System.in);
	System.out.print("What is the length of the second list: ");
	int length2 = input.nextInt();

	int[] list1= new int [length1];
	int[] list2= new int [length2];
	
	
	for (int i=0; i<length1; i++) {
		Scanner input3 = new Scanner(System.in);
		System.out.print("What is element " + i + " in the first sorted list: ");
		int element = input3.nextInt();  
		
		list1[i] = element;
	}
	
	for (int i=0; i<length2; i++) {
		Scanner input4 = new Scanner(System.in);
		System.out.print("What is element " + i + " in the second sorted list: ");
		int element = input4.nextInt();  
		
		list2[i] = element;
	}	

	if (isSorted(list1)==false || isSorted(list2)==false) {
		System.out.println();
		System.out.print("One of your lists isn't sorted.");
		System.exit(0);
	}
	
	else {
		int[] mergedList = new int[length1+length2]; 
		
		mergedList = merge(list1,list2);
		
		System.out.println();
		System.out.print("This is the merged list: " + mergedList[0]);
		for (int i=1; i<length1+length2; i++) {
			System.out.print(", " + mergedList[i]);

}

}
}
}
