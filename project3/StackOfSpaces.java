package project3;


/**
 *  This class is a referenced based Stack implementation that uses nodes
 *  that hold SquarePositions as their data field.
 * @author christianmiljkovic
 *
 */
public class StackOfSpaces implements SetOfSpaces {

	// create the data fields for the StackOfSpaces class
	private Node top;
	private static int size = 0;

	// create a default constructor
	public StackOfSpaces() {
		this.top = null;
	}

	/**
	 * Add a SquarePosition object to the StackOfSpaces.
	 * 
	 * @param s
	 *            object to be added
	 */
	public void add(SquarePosition s) {

		// check if the object is null or not
		if (s == null)
			return;

		// make new node with node's SquarePosition attribute s
		// make new node's next point to head
		// point head to new node
		Node current = new Node(s);

		// check to see if head is pointing to null
		if (top == null) {

			// if so set top to the newly created node
			top = current;
			size++;
		}

		// if there are other nodes
		else {
			// set the newly made node to the one that top was pointing to
			// then have top point to current in order to follow stack
			// implementation
			current.setNext(top);
			top = current;
			size++;
		}

	}

	/**
	 * Determines if set is empty or not.
	 * 
	 * @return true, if set is empty, false, otherwise.
	 */
	public boolean isEmpty() {

		// check if top is null because if it is then there are no nodes and the
		// stack is therefore empty
		if (top == null)
			return true;

		else
			return false;

	}

	/**
	 * Remove the next object from the set. The specific item returned is
	 * determined by the underlying structure of set representation.
	 * 
	 * @return the next object, or null if set is empty
	 */
	public SquarePosition remove() {

		// check to see if the list is empty
		if (top != null) {

			// check to see if there is just one node
			if (size == 1) {

				// create a temp variable to hold the data from the node
				SquarePosition temp = top.getData();

				// point top to none to get rid of the last node
				top = null;

				size--; // decrement size

				// return the data that we stored previously
				return temp;

			}

			else {
				// create a temp variable to hold the data from the node
				SquarePosition temp = top.getData();

				// decrement the size
				size--;

				// point top to the next node to remove the previous one
				top = top.getNext();

				// return the data from the node
				return temp;

			}

		} else
			return null;
	}

	public static int getSize() {
		return size;
	}

	/**
	 * @return the top
	 */
	public Node getTop() {
		return top;
	}

}


