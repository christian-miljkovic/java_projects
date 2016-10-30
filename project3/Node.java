package project3;


/**
 * This class is a acts as a node that contains a SquarePosition object as its
 * data field. This class is later used to created a referenced based stack and queue.
 * @author christianmiljkovic
 *
 */
public class Node {

	// create the data fields for the Node
	private SquarePosition s;
	private Node next;

	public Node() {
		this.next = null;
	}

	public Node(SquarePosition s) {
		// set the SquarePosition data field if it is not null
		if (s != null) {
			this.s = s;
			this.next = null;
		}

	}

	/**
	 * @return the SquarePosition
	 */
	public SquarePosition getData() {
		return s;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}



}
