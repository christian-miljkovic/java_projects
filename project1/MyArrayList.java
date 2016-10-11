package project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author christianmiljkovic This class creates a MyArrayList object which
 *         extends the ArrayList class and implements the Comparable class. This
 *         acts as a generic container class.
 * 
 */
public class MyArrayList<E extends Comparable<E>> extends ArrayList<E> {

	// when you have generics you extend Comparable<E>

	/**
	 * This method sorts a Collections object
	 */
	public void sort() {
		Collections.sort(this);
	}

	/**
	 * This method checks whether the MyArrayList object is sorted
	 * 
	 * @return true if the list is sorted and false if it is not
	 */
	public boolean isSorted() {

		// loop through the MyArrayList to check if it is sorted
		for (int i = 0, j = 1; j < this.size(); j++, i++) {

			// use the comparedTo method for the specified class
			// if the compareTo method returns a higher number than 0 then
			// return false
			// which indicates that it is not sorted
			if (this.get(i).compareTo((E) this.get(j)) > 0) {
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ArrayList#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {

		// if the list is sorted than use a binary search method
		if (this.isSorted() == true) {
			int num = this.binarySearch(o);

			if (num == -1) {
				return false;
			}

			else {
				return true;
			}
		}

		// if the list is not sorted use the contains method inherited from the
		// ArrayList class
		else
			return super.contains(o);

	}

	/**
	 * This method performs a binary search for a certain object
	 * 
	 * @param o
	 * @return the index of where the object is located or -1 if it is not
	 *         within the list
	 */
	public int binarySearch(Object o) {

		int min = 0;
		int max = this.size() - 1;

		// use a while loop to find the object you're looking for within the
		// list
		// and if the object is not there then return -1
		while (max >= min) {
			int mid = (min + max) / 2;

			// make sure that the object is of Comparable generic type due to
			// the class
			if (((Comparable<E>) o).compareTo(this.get(mid)) == 0)
				return mid;

			else if (((Comparable<E>) o).compareTo(this.get(mid)) < 0)
				max = mid - 1;

			else if (((Comparable<E>) o).compareTo(this.get(mid)) > 0)
				min = mid + 1;

		}
		return -1;

	}

}
