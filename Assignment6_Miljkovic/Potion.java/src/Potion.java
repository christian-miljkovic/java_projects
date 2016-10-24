/**
 * This class creates an object called Potion which has the properties of having 
 * a certain capacity and the ability to hold ingredients. There are also methods
 * with which to manipulate the contents of the potion.
 * @author christianmiljkovic
 * @version 03/30/16
 *
 */

public class Potion 
{
	//create the private data fields of the object
	private int numIngredients;
	private String ingredients="";
	
	/**
	 * This is an no arg constructor that creates a default potion object
	 * to have a capacity of 10.
	 */
	public Potion() 
	{
		numIngredients=10;
		ingredients="";
	}
	/**
	 * This is a constructor that creates a chosen capacity for a potion bottle.
	 * @param numIngredients: which is an integer that represents the capacity of the bottle.
	 */
	public Potion(int numIngredients) 
	{
		this.numIngredients= numIngredients;
		ingredients="";
	}
	
	/**
	 * This method adds an ingredient or character to the string that represents the list 
	 * of ingredients within the potion bottle object.
	 * @param ingredient: which is a character that represents an ingredient
	 * @return: true if the ingredient was succesfully added to the potion or false if it wasnt.
	 */
	public boolean addIngredient(char ingredient) 
	{
		if (ingredients.length() < numIngredients) 
		{
			//check to see that the ingredients are valid 
			if (ingredient=='a' | ingredient=='b' | ingredient=='c' | ingredient=='d' | ingredient=='w')
			{
				//add the ingredient if it is valid
				ingredients+=ingredient;
				return true; 
			}
			//if it is an invalid ingredient
			else 
				return false;
		}
		//if there is no more space in the potion bottle
		else
			return false;
	}
	/**
	 * This method returns the ingredients that are held within the potion bottle.
	 */
	public String toString()
	{
		return ingredients;
	}
	/**
	 * This method heats up the potion and removes the character 'w' representing water from the String
	 * that represents the ingredients within the potion.And it determines whether there was water in the potion bottle.
	 * @return: true if there was water in the string and false if there wasn't.
	 */
	public boolean heatPotion() 
	{
		int count=0;
		for (int i=0; i < ingredients.length(); i++) 
		{
			if (ingredients.charAt(i)=='w') 
			{
				//take out the water and count that it was there
				ingredients = ingredients.replace("w", "");
				count+=1;
			}
		}
		//check that there was water in the potion in order to have it properly heated
		if (count > 0) 
		{
			return true;
		}
		
		else
			return false;
	}
	/**
	 * This method discards all of the contents of the potion into an object called bucket.
	 * @param b: this represents a bucket object.
	 */
	public void discardPotion(Bucket b) 
	{
		//run through the contents of the potion and then add them to the bucket
		for (int i=0; i < this.ingredients.length(); i++ ) 
		{
			b.dumpIngredient(ingredients.charAt(i));
		}
		//clear the ingredients in the bottle
		this.ingredients="";
	}
	/**
	 * This method checks to see if the potion bottle if full.
	 * @return: true if the potion is full and false if it is not.
	 */
	public boolean isFull() 
	{
		if (this.numIngredients==ingredients.length())
			return true;
		
		else
			return false;
	}
	
	
}
