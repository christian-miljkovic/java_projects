package project1;

/**
 * @author christianmiljkovic 
 * This class implements Comparable<Name> interface
 * and creates the object Name
 */
public class Name implements Comparable<Name> {

	// data fields for the class
	String name;
	String gender;
	int count;

	public Name(String name, String gender, int count) throws IllegalArgumentException {

		// check if the input is correct
		if (name.isEmpty())
			throw new IllegalArgumentException("Name input is invalid.");
		else
			this.name = name;

		// check if the gender is correct
		if (gender.equalsIgnoreCase("f") == true || gender.equalsIgnoreCase("m") == true)
			this.gender = gender;

		else
			throw new IllegalArgumentException("Gender input is invalid.");

		// check if the count is greater than
		if (count < 0)
			throw new IllegalArgumentException("Count input is invalid.");

		else
			this.count = count;
	}

	@Override
	/**
	 * Compares this Name object with the specified Name object for order.
	 * 
	 * 
	 * @param: Name
	 *             o
	 * @return: Returns a -1 or 1 if the Name object's count is less than or
	 *          greater than the specified object's count. If the counts are the
	 *          same then this method returns 1, 0 , or -1 if the String name of
	 *          this object is greater than, the same, or less than the
	 *          specified object's name.
	 */
	public int compareTo(Name o) {

		// use the count as the main key to compare objects

		// if the counts are the same then compare the names using String
		// compareTo
		if (this.count == o.count) {
			int return_val = this.name.compareTo(o.name);

			if (return_val > 0)
				return 1;

			else if (return_val < 0)
				return -1;

			else
				return 0;
		}

		else if (this.count < o.count)
			return -1;

		else
			return 1;

	}

	@Override
	/**
	 * This method returns the string representation of the Name class
	 */
	public String toString() {
		return this.name + " " + this.gender + " " + this.count;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Name other = (Name) obj;
		if (count != other.count) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}

			// use ignore case because of the user input
		} else if (!name.equalsIgnoreCase(other.name)) {
			return false;
		}
		return true;
	}

}
