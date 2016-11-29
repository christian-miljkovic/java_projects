package project4;



/**
 * This class is a acts as a node that contains a generic object as its
 * data field. This class is later used to created a referenced based binary tree.
 * @author christianmiljkovic
 *
 */
public class BSTNode<E extends Comparable<E>> 
	implements Comparable <BSTNode <E> >{
	
	// create the data fields for the Node
	private BSTNode<E> right;
	private BSTNode<E> left;
	private E data;

	
	//create three different constructors for the class 
	//default
	BSTNode() {
		this.left = null;
		this.right = null;
	}
	
	//constructor with only data as parameter
	BSTNode(E data) {
		this.left = null;
		this.right = null;
		this.data = data;
		
	}
	
	//constructor with data and left and right node
	BSTNode(E data,BSTNode<E> right,BSTNode<E> left) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	/**
	 * @return the right node
	 */
	BSTNode<E> getRight() {
		return right;
	}

	/**
	 @param a BST node that will be the right one
	 */
	void setRight(BSTNode<E> right) {
		this.right = right;
	}

	/**
	 * @return the left node
	 */
	BSTNode<E> getLeft() {
		return left;
	}

	/**
	 * @param a BST node that will be the left one
	 */
	void setLeft(BSTNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the data
	 */
	E getData() {
		return data;
	}

	/**
	 * @param the data that you want to set
	 */
	void setData(E data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [right=" + right + ", left=" + left + ", data=" + data + "]";
	}
	
	/**
	 * Compares this BSTNode<E> object with the specified object for order.
	 * 
	 * 
	 * @param: BSTNode<E>
	 *             o
	 * @return: Returns a -1 or 1 if the Node object's data is less than or
	 *          greater than the specified object's data. If the Node object's data is the
	 *          same then this method returns 0.
	 */
	public int compareTo(BSTNode<E> other) {
		return this.data.compareTo(other.data);
	} 
	
}
