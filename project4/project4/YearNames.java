package project4;


public class YearNames extends MyBST{

	// data fields for the class
	private MyBST<Name> year_names;
	private int year;
	private int total_count;
	
	public YearNames(int year) {
		this.year = year;
		this.year_names = new MyBST<Name>();
		this.total_count = 0;
	}
	
	
	
	/**
	 * This method adds names to the YearName object
	 * 
	 * @param n
	 * @throws IllegalArgumentException
	 */
	public boolean add(Name name) throws IllegalArgumentException {

		// make sure that there aren't any of the same objects within the
		// YearName object already
		if (this.contains(name))
			throw new IllegalArgumentException("That name is already in the list");
		
		else { 
			total_count += name.getCount();
			return super.add(name);
		}
	}
	
	/**
	 * This method acts as the wrapper class for the actual method that finds the count by name
	 * @param name 
	 * @param gender
	 * @return the number of babies named the given name
	 */
	public int getCountByName( String name, String gender ) {
		
		//check whether the parameters inputed are valid and if not throw 
		//an Illegal argument exception
		if((gender.equalsIgnoreCase("f")==false) && (gender.equalsIgnoreCase("m")==false))
			throw new IllegalArgumentException("The gender is invalid.");
		
		if(gender==null)
			throw new IllegalArgumentException("The gender is null."); 
		
		if(name==null)
			throw new IllegalArgumentException("The name is null."); 
		
		//if the parameters are valid then create a new name object in order to 
		//use the actual method
		Name name2 = new Name( name, gender, 1 );
		return getCountByName(name2,this.root);
	
	}
	
	/**
	 * This is the actual method that does recursively finds the count of a name
	 * that is located in a BST
	 * @param name string of you are looking for 
	 * @param root the start of the BST
	 * @return the count of the name provided in the parameters
	 */
	public int getCountByName(Name name, BSTNode<Name> root) {
		
		//check to make sure that the BST is not empty
		if(root==null)
			return 0;
			
		//if it is not empty then go 
		//through the BST searching for name to get the count
			
		//check whether you have to go left or right
		if(name.compareNames(root.getData()) < 0)
			return getCountByName(name,root.getLeft());
			
		else if (name.compareNames(root.getData()) > 0)
			return getCountByName(name, root.getRight());
				
		else
			return root.getData().getCount();
		
	}
	
	/**
	 * This class figures out the percentage of babies born in a certain year
	 * with the specified name
	 * 
	 * @param string representation of the name and the string representation of the gender
	 * @return the percent of babies with a given name
	 */
	public double getFractionByName ( String name, String gender ) {
		//check whether the parameters inputed are valid and if not throw 
		//an Illegal argument exception
		if((gender.equalsIgnoreCase("f")==false) && (gender.equalsIgnoreCase("m")==false))
			throw new IllegalArgumentException("The gender is invalid.");
				
		if(gender==null)
			throw new IllegalArgumentException("The gender is null."); 
				
		if(name==null)
			throw new IllegalArgumentException("The name is null."); 
				
		//if the parameters are valid then use get the count of the name using the getCountByName method
		double count = (double) getCountByName(name, gender);
		double name_fraction = (double) (count/total_count);
		
		return name_fraction;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "YearNames [year_names=" + year_names + ", year=" + year + ", total_count=" + total_count + "]";
	}
	
	
	/**
	 * This method checks whether the object exists within the the BST and acts
	 * as the wrapper class for the private recursive method
	 * 
	 * @param o
	 *            any object
	 * @return true if the object exists within the BST
	 */
	public boolean containsName(Name o) {

		// check to see if the object is not null
		if (o == null)
			return false;

		// check to see if the BST is empty
		if (root == null)
			return false;

		return containsName(o,this.root);

	}

	/**
	 * This method recursively searches through the YearNames container to see if it contains
	 * the name that is placed in the parameter
	 * 
	 * @param n
	 *            name being searched for
	 * @param root
	 *            the root to start the search from
	 * @return true or false if the object is found or not
	 */
	private boolean containsName(Name n, BSTNode<Name> root) {

		// check if the root is not null
		if (root == null)
			return false;

		// check to see whether you have to go to the right side of the current
		// root
		if (root.getData().compareNames(n) < 0)
			return containsName(n, root.getRight());

		// check to see whether you have to go to the left side of the current
		// root
		else if (root.getData().compareNames(n) > 0)
			return containsName(n, root.getLeft());

		// if you don't reach null and compareTo returns zero then we know we
		// found the item
		// so return true
		else
			return true;

	}



	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	
	
	
	
	

	
}
