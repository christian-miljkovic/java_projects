package project4;

/**
 * @author christianmiljkovic 
 * This class implements Comparable<Name> interface
 * and creates the object Name
 */
public class Name implements Comparable<Name> {

	// data fields for the class
	private String name;
	private String gender;
	private int count;

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
	 * @return: Returns a -1 or 1 if the Name object's name is less than or
	 *          greater than the specified object's name. If the name are the
	 *          same then this method returns 1, 0 , or -1 if the String gender of
	 *          this object is greater than, the same, or less than the
	 *          specified object's gender. If the genders are equal then the same is repeated
	 *          for the count data fields.
	 */
	public int compareTo(Name o) {

		// use the name as the main key to compare objects

		// if the names are the same then compare the names using gender
		//then count
		if (this.name.compareToIgnoreCase(o.name) == 0) {
			
			//make the names all lower case 
			String this_gender = this.gender.toLowerCase();
			String o_gender = o.gender.toLowerCase();
			
			int return_val = this_gender.compareToIgnoreCase(o_gender);

			if (return_val > 0)
				return 1;

			else if (return_val < 0)
				return -1;

			else {
				
				if(this.count > o.count)
					return 1;
				
				else if (this.count < o.count)
					return -1;
				
				else
					return 0;
				
			}
		}

		else if (this.name.compareToIgnoreCase(o.name) < 0)
			return -1;

		else
			return 1;

	}
	
	/**
	 * This method is similar to the compareTo method however
	 * instead of comparing all data fields it excludes the count data field
	 * @param o a name object
	 * @return Returns a -1 or 1 if the Name object's name is less than or
	 *          greater than the specified object's name. If the name are the
	 *          same then this method returns 1, 0 , or -1 if the String gender of
	 *          this object is greater than, the same, or less than the
	 *          specified object's gender. 
	 */
	public int compareNames(Name o) {

		// use the name as the main key to compare objects

		// if the names are the same then compare the names using gender
		if (this.name.compareToIgnoreCase(o.name) == 0) {
			
			//make the names all lower case 
			String this_gender = this.gender.toLowerCase();
			String o_gender = o.gender.toLowerCase();
			
			int return_val = this_gender.compareToIgnoreCase(o_gender);

			if (return_val > 0)
				return 1;

			else if (return_val < 0)
				return -1;

			else {
				return 0;
			}
		}
		
		//this is if the two objects don't have the same names
		else if (this.name.compareToIgnoreCase(o.name) < 0)
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
		
		if (name == null) {
			if (other.name != null) {
				return false;
			}

			// use ignore case because of the user input
		} else if (!name.equalsIgnoreCase(other.name)) {
			return false;
		}
		
		if (count != other.count) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equalsIgnoreCase(other.gender)) {
			return false;
		}

		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the count
	 */
	int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	void setCount(int count) {
		this.count = count;
	}
	
	
	
	

}
