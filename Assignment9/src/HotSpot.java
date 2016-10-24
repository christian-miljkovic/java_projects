/**
 * This class creates an object of the type HotSpot
 * that is used in the FindHotSpots program.
 * @author christianmiljkovic
 * @verison 1.0
 * @date 05/05/16
 */

import java.util.Arrays;

public class HotSpot 
{
	//create the data fields
	String type;
	String location;
	String city;
	double latitude;
	double longitude;
	
	
	/**
	 * This is a constructor that creates a HotSpot object
	 * @param type: string that indicates whether it is free or otherwise
	 * @param location: string that is the address of the hotspot
	 * @param city: string that is the city of the respective hotspot
	 * @param latitude: double that represents the latitude of the hotspot
	 * @param longitude: double that represents the longitude of the hotspot
	 */
	HotSpot(String type, String location, String city, double latitude, 
			double longitude) 
	{
		
		//set the constructors properties with its data fields
		this.type=type;
		this.location=location;
		this.city=city;
		this.latitude=latitude;
		this.longitude=longitude;
		

	}
	
	/**
	 * This method gives the ability for other classes within the package
	 * to print the data fields within the hotspot object.
	 */
	public String toString() 
	{
		return this.type + " " + this.location + " " + this.city +
				" " + this.latitude + " " + this.longitude;
	}
}
