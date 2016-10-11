package project1;

/**
 * @author christianmiljkovic This class creates a YearName object that acts as
 *         a container for Name objects
 */
public class YearNames {

	// data fields for the class
	MyArrayList<Name> year_names;
	int year;

	public YearNames(int year) {
		this.year = year;
		this.year_names = new MyArrayList<Name>();
	}

	/**
	 * This method adds names to the YearName object
	 * 
	 * @param n
	 * @throws IllegalArgumentException
	 */
	public void add(Name n) throws IllegalArgumentException {

		// make sure that there arent any of the same objects within the
		// YearName object already
		if (year_names.contains(n))
			throw new IllegalArgumentException("That name is already in the list");

		else
			year_names.add(n);

	}

	/**
	 * This method gets the count of a name object and returns it
	 * 
	 * @param name
	 * @return the total count of babies with the certain name
	 */
	public int getCountByName(String name) {
		int total_count = 0;

		// loop through the YearName object in order to find the total count for
		// each baby name
		for (int i = 0; i < this.year_names.size(); i++) {

			if (this.year_names.get(i).name.compareTo(name) == 0)
				total_count += this.year_names.get(i).count;
		}

		return total_count;

	}

	/**
	 * This class figures out the percentage of babies born in a certain year
	 * with the specified name
	 * 
	 * @param name
	 * @return the percent of babies with a given name
	 */
	public double getFractionByName(String name) {

		int name_count = this.getCountByName(name);
		double number_babies = 0;
		double name_fraction = 0;

		// look through the YearName object in order to find the total amount of
		// babies
		// in order to get the percentage

		for (int i = 0; i < this.year_names.size(); i++) {
			number_babies += this.year_names.get(i).count;
		}

		// calculate the percentage of babies with the specified name
		name_fraction = ((double) name_count) / number_babies;

		return name_fraction;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "YearNames [year_names=" + year_names + ", year=" + year + "]";
	}

}
