package project4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyBST<E extends Comparable<E>> {

	public BSTNode<E> root;

	// current number of nodes in the tree
	private int numOfElements;

	// creates the constructor for the class
	public MyBST() {
		this.root = null;
		this.numOfElements = 0;
	}

	/**
	 * Checks to see whether the tree is empty or not
	 * 
	 * @return true if there are elements in the tree
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Add the given data item to the tree. If item is null, the tree does not
	 * change.
	 * 
	 * @param item
	 *            the new element to be added to the tree all elements must be
	 *            new
	 */
	public boolean add(E e) {

		// check to see if the object that is trying to be added
		// is null or not
		if (e == null)
			return false;

		// check to make sure that the object is not already in the BST
		if (this.contains(e) == true)
			return false;

		// check to see if the root is null indicating the
		// object added should be the first
		if (this.root == null) {
			root = new BSTNode<E>(e);
			numOfElements++;
			return true;
		}

		// check to see if the object already exists

		else {
			// use a node to loop through the tree and a node to act as the
			// parent
			BSTNode<E> parent = null;
			BSTNode<E> current = this.root;

			// start looping through the tree
			while (current != null) {

				// go to the left of the tree if the item being added is less
				// than the root
				if (e.compareTo(current.getData()) < 0) {
					parent = current;
					current = current.getLeft();
				}

				// go to the right of the tree if the item being added is
				// greater than the root
				else {
					parent = current;
					current = current.getRight();
				}

			}

			// place the item to the left if it is less than the parent
			if (e.compareTo((E) parent.getData()) < 0) {
				parent.setLeft(new BSTNode<E>(e));
				numOfElements++;
				return true;
			}

			// place the item to the right if it greater than the parent
			else {
				parent.setRight(new BSTNode<E>(e));
				numOfElements++;
				return true;
			}

		}

	}

	/**
	 * This method checks whether the object exists within the the BST and acts
	 * as the wrapper class for the private recursive method
	 * 
	 * @param o
	 *            any object
	 * @return true if the object exists within the BST
	 */
	public boolean contains(Object o) {

		// check to see if the object is not null
		if (o == null)
			return false;

		// check to see if the BST is empty
		if (this.root == null)
			return false;

		return contains(o, root);

	}

	/**
	 * This method recursively searches through the BST to see if it contains
	 * the object that is placed in the parameter
	 * 
	 * @param o
	 *            object being searched for
	 * @param root
	 *            the root to start the search from
	 * @return true or false if the object is found or not
	 */
	private boolean contains(Object o, BSTNode<E> root) {

		// check if the root is not null
		if (root == null)
			return false;

		// check to see whether you have to go to the right side of the current
		// root
		if (root.getData().compareTo((E) o) < 0)
			return contains(o, root.getRight());

		// check to see whether you have to go to the left side of the current
		// root
		else if (root.getData().compareTo((E) o) > 0)
			return contains(o, root.getLeft());

		// if you don't reach null and compareTo returns zero then we know we
		// found the item
		// so return true
		else
			return true;

	}

	/**
	 * This method returns the first (lowest) element currently in this set.
	 * 
	 * @return E
	 */
	public E first() {

		// check to make sure that the root isn't null
		if (root == null)
			return null;

		// if it is not null then loop through the BST to get to the
		// smallest value
		else {
			// use a current node to loop through
			BSTNode<E> current = root;

			// make sure that you stop when you reach the leaves
			while (current.getLeft() != null) {
				current = current.getLeft();
			}
			return (E) current.getData();
		}
	}

	/**
	 * This method returns the last (highest) element currently in this set.
	 * 
	 * @return E
	 */
	public E last() {

		// check to make sure that the root isn't null
		if (root == null)
			return null;

		// if it is not null then loop through the BST to get to the
		// highest value
		else {
			// use a current node to loop through
			BSTNode<E> current = root;
			E current_data = (E) root.getData();

			// make sure that you stop when you reach the leaves
			while (current.getRight() != null) {
				current = current.getRight();
				current_data = (E) current.getData();
			}
			return current_data;
		}

	}

	/**
	 * This method removes an item from the tree and if the item is null or does
	 * not exist then the tree remains unchanged
	 * 
	 * @param o
	 *            the object that is being removed
	 * @return true or false depending upon when
	 */
	public boolean remove(Object o) {

		// check to see if the tree is empty
		if (root == null)
			return false;

		// check to see if the object is null
		if (o == null)
			return false;

		// check to see if the object is in the BST
		// and find the parent and current node where the object is contained
		else {
			// create the node that will loop through the BST
			// and the other node to hold the position
			BSTNode<E> current = root;
			BSTNode<E> parent = current;

			// loop through the BST and locate the node with the object
			while (current != null) {

				if (current.getData().compareTo((E) o) > 0) {
					parent = current;
					current = current.getLeft();
				}

				else if (current.getData().compareTo((E) o) < 0) {
					parent = current;
					current = current.getRight();
				}

				else
					break; // this indicates that the object with the node was
							// found
			}

			// check to make sure that current isn't null because then the item
			// is not in the
			// BST
			if (current == null)
				return false;

			// Since there are two cases you have to deal with when removing
			// check whether the current node has a left child
			if (current.getLeft() == null) { // if it doesn't then connect to
												// the parent node
				// this is the case for if we are at the root
				if (parent == null) {
					root = current.getRight();
					numOfElements--;
					return true;
				}

				// if not then we know we are further down the BST
				else {
					// if the object is smaller than the parent data then set
					// the left child to the current data
					if (parent.getData().compareTo((E) o) > 0) {
						parent.setLeft(current.getRight());
						numOfElements--;
						return true;
					}
					// use the right side data
					else {
						parent.setRight(current.getRight());
						numOfElements--;
						return true;
					}

				}
			}

			// this is for the case where the current node has a left child
			// where you have to get the "lowest" object in the right side of
			// the subtree
			// and then replace the removed node with that "least" node
			else {
				BSTNode<E> parentRight = current;
				BSTNode<E> currentRight = current.getLeft();

				while (currentRight.getRight() != null) {
					parentRight = currentRight;
					currentRight = currentRight.getRight();
				}

				// replace the item in the current node
				current.setData(currentRight.getData());

				// get rid of the right most node
				if (parentRight.getRight() == currentRight) {
					parentRight.setRight(currentRight.getLeft());
					numOfElements--;
					return true;
				}

				else { // only if the parentRight == current
					parentRight.setLeft(currentRight.getLeft());
					numOfElements--;
					return true;
				}
			}
		}

	}

	/**
	 * This method creates a MyIterator that is an implementation of the
	 * iterator interface
	 * 
	 * @return MyIteration object
	 */
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	/**
	 * This private class implements the iterator interface for this specific
	 * class
	 * 
	 * @author christianmiljkovic
	 *
	 */
	private class MyIterator implements Iterator<E> {

		// create the data fields for the MyIterator class
		private int cursor;
		ArrayList<E> container = new ArrayList<E>(); // this will hold the data

		// creates the constructor for the class using inOrder method
		// implemented below
		public MyIterator() {
			inOrder(root);
		}

		/**
		 * This method traverses through the BST inOrder recursively and adds
		 * the elements in the BST to the array list
		 * 
		 * @param takes
		 *            the root of the BST that is inspected
		 */
		public void inOrder(BSTNode<E> root) {
			// check to make sure that the root is not null
			if (root != null) {
				// then first go from left to right recursively
				inOrder(root.getLeft());

				// then add the element to the array list container
				container.add((E) root.getData());

				// then go through the right side of the tree
				inOrder(root.getRight());

			}
		}

		/**
		 * This method checks to see if there is another element in the array
		 * list representation of the BST and returns true if there is and false
		 * if not
		 */
		@Override
		public boolean hasNext() {

			return cursor != numOfElements;
		}

		/**
		 * This method returns the next object in the array list representation
		 * of the BST
		 */
		@Override
		public E next() {

			// check to see whether the cursor is greater than or equal to
			// the number of elements in the array list representation of the
			// BST
			if (cursor >= numOfElements)
				throw new NoSuchElementException();

			// if not then increase the cursor
			cursor++;

			// return the object that represents the next element in the BST
			return container.get(cursor - 1);

		}

	}
	

	/*
	 * @param tree the root of the current subtree
	 * 
	 * @param level level (depth) of the current recursive call in the tree to
	 * determine the indentation of each item
	 * 
	 * @param output the string that accumulated the string representation of
	 * this BST
	 */
	private void preOrderPrint(BSTNode<E> tree, int level, StringBuilder output) {
		if (tree != null) {
			String spaces = "\n";
			if (level > 0) {
				for (int i = 0; i < level - 1; i++)
					spaces += "   ";
				spaces += "|--";
			}
			output.append(spaces);
			output.append(tree.getData());
			preOrderPrint(tree.getLeft(), level + 1, output);
			preOrderPrint(tree.getRight(), level + 1, output);
		}
		// uncomment the part below to show "null children" in the output
		else {
			String spaces = "\n";
			if (level > 0) {
				for (int i = 0; i < level - 1; i++)
					spaces += "   ";
				spaces += "|--";
			}
			output.append(spaces);
			output.append("null");
		}
	}

	/**
	 * Produces tree like string representation of this BST.
	 * 
	 * @return string containing tree-like representation of this BST.
	 */
	public String toStringTreeFormat() {

		StringBuilder s = new StringBuilder();

		preOrderPrint(root, 0, s);
		return s.toString();
	}

}
