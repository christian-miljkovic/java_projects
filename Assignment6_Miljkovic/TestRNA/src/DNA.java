/** 
 * The DNA program implements a DNA object
 * with a user input constructor and methods to validate the DNA strand, 
 * return the object as a string, and convert it to an RNA strand.
 * 
 * @author christianmiljkovic
 * @version 1.0
 * @since 2016-04-12
 *
 */

public class DNA 
{
	
	//DNA sequence of nucleotide basis
    private String sequence; 
    //valid/invalid indicator 
    private boolean valid; 

    /**
    * Initializes newly created DNA strand to the provided
    * sequence. The sequence is validated to contain only
    * legal nucleotides: guanine (G), adenine (A),
    * thymine (T), or cytosine (C). 
    * @param sequence the sequence of nucleotide basis to be used
    *    in this DNA 
    */
    public DNA ( String sequence ) 
    {
    	this.sequence= sequence;
    	
    	valid=this.isValid();

    }

    /*
    * Operates on the sequence of this DNA object. It returns true/false 
    * indicating validity of the sequence. The sequence is valid if it contains
    * only legal nucleotide basis: guanine (G), adenine (A),
    * thymine (T), or cytosine (C). The valid data field is set accordingly. 
    * @return true if the sequence in this DNA object is valid, false otherwise
    */
    private boolean validate () 
    {
    	//user a counter to check how many invalid characters there are if any
    	int count=0;
    	
    	//loop through strand and check characters using if-elif statements
    	for (int i=0; i < this.sequence.length(); i++) {
    		if (this.sequence.charAt(i)!='G' || this.sequence.charAt(i)!='g')
    			count++;
    		
    		else if (this.sequence.charAt(i)!='A' || this.sequence.charAt(i)!='a')
    			count++;
    		
    		else if (this.sequence.charAt(i)!='T' || this.sequence.charAt(i)!='t')
    			count++;	
    			
    		else if (this.sequence.charAt(i)!='C' || this.sequence.charAt(i)!='c') 
    			count++;
    	}
    	//if the count is greater than zero that means there is an invalid character
    	if (count>0)
    		return false; 
    	
    	else
    		return true;
    }

    /** 
    * Translates this DNA object to its corresponding RNA sequence. The DNA and RNA
    * are closely related. The major difference is that the RNA contains
    * uracil (U) rather than thymine (T). This method replaces every occurrence of T
    * in the sequence by U and returns the corresponding String object. 
    * @return the RNA sequence 
    */
    public String toRNA () 
    {
    	//new string in order to hold the new RNA sequence
    	String RNAsequence="";
    	
    	//run through the original strand to find the characters
    	//that need to be switched
    	for (int i=0; i < sequence.length(); i++) 
    	{
    		if (sequence.charAt(i) == 'T')
    			RNAsequence+='U';
    		else
    			RNAsequence+=sequence.charAt(i);
    	}
    	
    	return RNAsequence;

    }

    /**
    * Computes the complementary DNA strand. The DNA usually exists as a double 
    * helix: given the strand stored in this DNA object, this method computes
    * and returns the second strand from the helix. To compute the complementary 
    * strand all A's need to be swapped with T's (and vice versa) and all C's need 
    * to be swapped with G's (and vice versa), and then the resulting string is 
    * reversed.
    * @return DNA object containing the reverse complement of the sequence stored
    *    in this DNA object 
    */
    public DNA reverseComplement () 
    {    
    	//check if the strand is valid
    	if (this.isValid()==false)
    		return null;
    	
    	if (this.sequence.length() <= 0)
    		return null;
    	
    	//use a new string in order to create the complement strand
    	String complement="";
    	
    	//loop through the strand to switch characters with their
    	//complement equivalent
    	for (int i=0; i < this.sequence.length(); i++)
    	{
    		//using if elif statements switch each character and 
    		//add them to the new string
    		if (this.sequence.charAt(i)==('A') || this.sequence.charAt(i)==('a'))
    			complement+='T';
    		
    		else if (this.sequence.charAt(i)=='T' || this.sequence.charAt(i)=='t')
    			complement+='A';
    		
    		else if (this.sequence.charAt(i)=='C' || this.sequence.charAt(i)=='c')
    			complement+='G';
    		
    		else if (this.sequence.charAt(i)=='G' || this.sequence.charAt(i)=='g')
    			complement+='C';
    	}
    	
    	//create a new string to hold the reverse of the complement
    	String reverseComplement="";
    	
    	//loop through the complement strand backwards to reverse it
    	for (int i=complement.length()-1; i >= 0; i--) 
    	{
    		reverseComplement+=complement.charAt(i);
    	}
    	
    	DNA helix = new DNA(reverseComplement);
    	
    	
    	return helix;
    		
    }

    /**
    * Returns true if this DNA object contains a valid strand and false otherwise.
    * @return true if this DNA object contains a valid strand and false otherwise
    */
    public boolean isValid () 
    {
    	//count the times that there are correct characters
    	int count=0;
    	
    	//loop through the strand to check the characters
    	//use if-elif statements to check each character
    	for (int i=0; i < sequence.length(); i++) 
    	{
    		if (sequence.charAt(i)=='A' || sequence.charAt(i)=='a')
    			count++;
    		
    		else if (sequence.charAt(i)=='G' || sequence.charAt(i)=='g')
    			count++;
    		
    		else if (sequence.charAt(i)=='T' || sequence.charAt(i)=='t')
    			count++;
    		
    		else if (sequence.charAt(i)=='C' || sequence.charAt(i)=='c')
    			count++;
    			
    	}
    	
    	//valid strand if count equals the amount of characters in the strand
    	if (count==sequence.length())
    		return true;
    	
    	else
    		return false;
    }
    	

    /**
    * Returns the String representation of this DNA object which is the sequence 
    * itself.
    */
    public String toString ()
    {
    	return String.valueOf(sequence);

    }
}


