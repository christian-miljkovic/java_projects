/**
 * This class creates the InvalidZipCodeException
 * @author christianmiljkovic
 * @version 1.0
 * @date 05/05/16
 */
public class InvalidZipCodeException extends Exception 
{
	//create the data field
	private int zipCode;
	
	/**
	 * This constructor creates the InvalidZipCodeException object
	 * @param zipCode: an int of an invalid zip code
	 */
	public InvalidZipCodeException(int zipCode) 
	{
		//invoke the super class' constructor in order to set 
		//the data fields within the constructor
		super("Invalid Zip Code " + zipCode);
		this.zipCode=zipCode;
	}
	
	/**
	 * This method allows the zipCode object
	 * to be returned by other classes within the package.
	 * @return: zipCode object
	 */
	public int getZipCode() {
		return zipCode;
	}

}
