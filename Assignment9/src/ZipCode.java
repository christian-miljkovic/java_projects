/**
 * This class creates an object of the type ZipCode
 * that is used in the FindHotSpots program.
 * @author christianmiljkovic
 * @version 1.0
 * @date 05/05/16
 */
public class ZipCode 
{ 
	//create the data fields
	int zipCode;
	double latitude;
	double longitude;

	/**
	 * This is the constructor that creates the ZipCode object
	 * @param zipCode: int that represents the ZipCode's actual zip code
	 * @param latitude: double that represnts the latitude of the ZipCode object
	 * @param longitude: double that represnts the longitude of the ZipCode object
	 * @throws IllegalArgumentException
	 */
	ZipCode(int zipCode, double latitude, double longitude) throws IllegalArgumentException 
	{
		
		//use an if elif statement in order to check that each parameter is valid
		//and if it is not throw an IllegalArgumentException
		if (zipCode >= 10001 && zipCode <= 11697)
			this.zipCode= zipCode;
		
		else 
			throw new IllegalArgumentException("Invalid zip code.");
		
		if (latitude >= 40.510723 && latitude <= 40.899178)
			this.latitude=latitude;
		
		else 
			throw new IllegalArgumentException("Invalid latitude.");
		
		if (longitude >= -74.24194 && longitude <= -73.711159)
			this.longitude = longitude;
		
		else
			throw new IllegalArgumentException("Invalid longitude");
			
	}
	
	
	
	
	/**
	 * This method gives the ability for other classes within the package
	 * to print the data fields within the hotspot object.
	 */
	public String toString() 
	{
		return this.zipCode + " " + this.longitude + " " + this.latitude;
	}
	
	
	

}
