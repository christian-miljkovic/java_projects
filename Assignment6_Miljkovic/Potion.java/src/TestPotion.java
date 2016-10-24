/**
 * This class tests the potion and bucket class and their respective methods by 
 * attempting to create a valid potion from a long set of ingredients (or string of characters that represent ingredients)
 * @author christianmiljkovic
 * @version 03/30/16
 */
public class TestPotion 
{

	public static void main(String[] args)
	{
		//create a Potion that can hold 5 ingredients
		Potion testPotion = new Potion(5);
		
		//create a Bucket object
		Bucket testBucket = new Bucket();
		
		String itemsToMix = "brcaxpaxdqaqdrrdtpaxxdbapprbb"
				+ "pqaqaqqpacbxcaaprrardawpaccrxpabqqqqwcpqpxdawrpbadddddqppcacc"
				+ "bxdpbbpxwqqrcrbarraqqxpabrrbcrqpbbcxbbprqacb"
				+ "xbwaccpbrqadxpqdwrqawwdrcpwcqpqawpabrcqqxdabpbbbcppwpbx"
				+ "bdbbrbbcwaxrqxqcqdqpapwdcdadawxaxprrdxaqpbcpqcpdqbpwwwcxdwcar"
				+ "dcxcbcxxwwaqrcdxpwpdpaqrabwqddqqdqqpbarqqdqqcaddwwabdabraxxpabqxra"
				+ "brxdqqcaxaaxxaxqqbrcrracxwdqxxxwxbwdcwcpxrrrddcdxxdbwrwxppcpxcrxdxqrcq"
				+ "pawppcdqppbxbqbqawqwqcpcqapcwwawbrpqbpqcqxrrcarpbqqqacxadbararrxaawpqqac"
				+ "qprccrdqpraawcaabrqqrqqwbwdwqqdaqcqdqparbb";
			

		//create an index for running throught the string and the condition for the while loop
		boolean resultComplete=false;
		int index=0;
		
		while(resultComplete!=true) 
		{
			
			boolean filled=false;
			
			//iterate over all the items to mix in
			while (filled==false) 
			{
				
				
				//extract single item to mix in
				char item = itemsToMix.charAt(index);
					
				boolean result = testPotion.addIngredient(item);
					
				//dump the item if it is not valid
				if (result!=true)
				{
					testBucket.dumpIngredient(item);
						
					}
				//check if the potion is full
				index++;
				filled=testPotion.isFull();
			
			}
			
			//attempt to heat up the item when the potion is full
			resultComplete = testPotion.heatPotion();
			
			//discard the contents of the potion if there was no water
			if (resultComplete!=true) 
			{
				testPotion.discardPotion(testBucket);
			}
			
			}
		//print out the output
		System.out.println(testPotion.toString());
		System.out.println(testBucket.toString());
		
	}	

	

}


