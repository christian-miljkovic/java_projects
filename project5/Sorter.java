package project5;

import java.util.Comparator;

/**
 * This is an interface for implementing various sorting algorithms
 * 
 * @author Joanna Klukowska & Christian Miljkovic
 *
 * @param <E> the generic type of objects that are going to be sorted
 */
public interface Sorter<E extends Comparable<E>> {

	
	public void sort(  E[] list, Comparator<String> comparator );

	
}
