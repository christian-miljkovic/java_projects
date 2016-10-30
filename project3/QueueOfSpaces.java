package project3;


/**
 *  This class is a referenced based Queue implementation that uses nodes
 *  that hold SquarePositions as their data field.
 * @author christianmiljkovic
 *
 */
public class QueueOfSpaces implements SetOfSpaces {

	// create the data fields for the QueueOfSpaces class
	private Node front;
	private Node back;
	private static int size = 0;

	public QueueOfSpaces() {
		// set the data fields of the object
		front = null;
		back = null;

	}

	/**
	 * Determines if set is empty or not.
	 * 
	 * @return true, if set is empty, false, otherwise.
	 */
	public boolean isEmpty() {
		if (front == null & back == null)
			return true;
		else
			return false;
	}

	/**
	 * Add a SquarePosition object to the StackOfSpaces.
	 * 
	 * @param s
	 *            object to be added
	 */
	public void add(SquarePosition s) {

		// check to see if the object is null
		if (s == null)
			return;

		// if the queue is empty then make front and back point to same node
		if (front == null) {

			// create a new node with the SquarePosition and point front and
			// back to same node
			Node current = new Node(s);
			front = current;
			back = current;
			size++; // increment the size
		}

		// if the size is greater than or equal to 1 then you just have to
		// setNext the back Node to the new Node created
		else {

			// create a new node with the SquarePosition and then make back
			// point to the new node
			// once you set it's next Node to the new Node
			Node newNode = new Node(s);

			back.setNext(newNode);
			back = newNode;

			size++; // increment size

		}

	}

	/**
	 * Remove the next object from the set. The specific item returned is
	 * determined by the underlying structure of set representation.
	 * 
	 * @return the next object, or null if set is empty
	 */
	public SquarePosition remove() {

		// check if the queue is empty
		if (this.isEmpty() == true)
			return null;

		// check if the queue has only one node
		if (size == 1) {

			// store the data that is held within the node that is getting
			// removed
			SquarePosition temp = front.getData();
			front = null; // remove the 1 item

			// return the data from the deleted node
			return temp;
		}

		else {

			// store the data that is held within the node that is getting
			// removed
			SquarePosition temp = front.getData();

			// point front to the Node that is located immediately after the
			// Node getting removed
			front = front.getNext();
			size--; // decrement the size

			return temp; // return the data from the deleted node

		}
	}

	/**
	 * @return the front
	 */
	public Node getFront() {
		return front;
	}

	/**
	 * @return the back
	 */
	public Node getBack() {
		return back;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

}
