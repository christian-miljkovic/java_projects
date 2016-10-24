/**
 * This class creates the object Bucket with the property "dumped".
 * This object represents a bucket with a list of discarded ingredients
 * from the object called potions.
 * @author christianmiljkovic
 * @version 03/30/16
 */

public class Bucket 
{
	//set the private data field
	private String dumped="";
	
	/**
	 * This no arg constructor sets a default infinite size to the bucket object.
	 */
	public Bucket() 
	{
		dumped="";
	}
	
	/**
	 * This method adds an ingredient, which is represented by a character, to the 
	 * list of dumped ingredients in the bucket object. 
	 * @param ingredient: is a character that represents an ingredient from the potion object.
	 */
	public void dumpIngredient(char ingredient) 
	{
		dumped+=ingredient;
	}
	/**
	 * This method returns the list of dumped ingredients that are within the bucket.
	 */
	public String toString() 
	{
		return dumped;
	}
	/**
	 * This method returns the amount of ingredients that are held within the bucket.
	 * @return: the number of ingredients or characters within the bucket object.
	 */
	public int getSize() 
	{
		return dumped.length();
	}

}
