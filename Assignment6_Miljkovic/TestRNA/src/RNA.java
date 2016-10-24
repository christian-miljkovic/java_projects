/**
 * The RNA program implements a RNA object with a user input constructor
 * and methods that validate the strand, return the object as a string, and convert it to
 * a protein sequence.
 * 
 * @author christianmiljkovic
 * @version 1.0
 * @since 2016-04-12
 */


public class RNA {
	
	//RNA strand that is used in the object
	private String strand="";
	
	//valid/invalid indicator 
	private boolean valid;

	/**
	* Initializes newly created RNA strand to the provided
	* sequence. The sequence is validated to contain only
	* legal nucleotides: guanine (G), adenine (A), uracil (U), or cytosine (C). 
	* @param sequence the sequence of DNA basis to be used
	*    in this DNA 
	*/	
	public RNA(String strand) {
		this.strand=strand;
		
		valid = this.isValid();
	}
	
    /** 
    * Translates this RNA object to its corresponding protein sequence by comparing
    * the characters of the RNA strand to the codons which correspond to proteins. 
    * @return the protein sequence 
    */	
	public String toProtein( int position )
	{
		String [][] codons = {{ "AUU", "AUC", "AUA"  }, { "CUU", "CUC", "CUA", 
			   "CUG", "UUA", "UUG"  },  { "GUU", "GUC", "GUA", "GUG"  }, 
			   { "UUU", "UUC"  }, { "AUG"  }, { "UGU", "UGC"  },  
			   { "GCU", "GCC", "GCA", "GCG"  }, { "GGU", "GGC", "GGA", "GGG"  }, 
			   { "CCU", "CCC", "CCA", "CCG"  },  { "ACU", "ACC", "ACA", "ACG"  }, 
			   { "UCU", "UCC", "UCA", "UCG", "AGU", "AGC"  }, { "UAU", "UAC"  }, 
			   { "UGG"  }, { "CAA", "CAG"  }, { "AAU", "AAC"  }, { "CAU", "CAC"  }, 
			   { "GAA", "GAG"  },  { "GAU", "GAC"  }, { "AAA", "AAG"  }, 
			   { "CGU", "CGC", "CGA", "CGG", "AGA", "AGG"  },  { "UAA", "UAG", "UGA"  }};
		
		String [] proteins = { "I", "L", "V", "F", "M", "C", 
			   "A", "G", "P", "T", "S", "Y", "W", "Q", "N", 
			   "H", "E", "D", "K", "R", "stop"};
		
		//validate the users input and return null if the input is not valid
		if (position < 0 || position > this.strand.length()-1)
			return null;
		
		else if (this.isValid()==false)
			return null;
		
		else if(this.strand.length()==0 || this.strand.length()<3)
			return null;
		
		//create an array in order to split the RNA strand into its codons
		String[] RNAcodons=new String[(this.strand.length()-position)/3];
		
		//holding variables for counting the amount of codons and holding the codons
		String single_codon="";
		int count=0;
		int index=0;
		
		//use a for loop to fill in the RNAcodons array every three characters
		for (int i=position; i < this.strand.length(); i++)
		{
			if(count<3)
				single_codon+=this.strand.charAt(i);
			//count how many characters are looped through in order to organize the strand into codons
			count++;
			
			if(count==3)
			{
				//add the full codon to the holding array
				RNAcodons[index]=single_codon;
				index++;
				
				//reset the count and codon holder
				single_codon="";
				count=0;
			}
		}
		//create index array that will give the index equivalent of the proteins
		int[] proteinIndex= new int[RNAcodons.length];
		
		//match the codons taken from the RNA strand and match them to the list given above
		//use a for loop to run through both arrays
		for (int i=0; i < RNAcodons.length; i++)
		{
			
			//run through the codons array
			for(int row=0; row < codons.length; row++) 
			{
				for(int col=0; col < codons[row].length; col++)
				{
					
					if (RNAcodons[i].equals(codons[row][col]))
						//set the index if you find a correct sequence that matches 
						proteinIndex[i]=row;
				}
			}
		}
		
		//create a new string in order to hold the protein sequence
		String proteins_sequence="";
		
		//loop through the array that holds the protein characters
		for (int i=0; i < proteinIndex.length; i++)
		{
			//if the codon stop is reached stop the sequence
			if (proteins[proteinIndex[i]].equals("stop"))
				break;
			else
				proteins_sequence+=proteins[proteinIndex[i]];
		}
		
		//if there are no proteins in the array return null
		if(proteins_sequence.length()==0)
			return null;
		
		return proteins_sequence;
		
	}
	
	
    /**
    * Returns true if this DNA object contains a valid strand and false otherwise.
    * @return true if this DNA object contains a valid strand and false otherwise
    */
	private boolean isValid() 
	{
		//use a counter in order to determine how many characters
		//are correct
		int count=0;
		
		String str = this.strand;
		
		//loop through the strand to determine if each character is correct
		for (int i=0; i < str.length(); i++)
		{
			//use an if-elif statement to determine whether it is a valid
			//or not valid character
			
			if (str.charAt(i)=='U' || str.charAt(i)=='u')
				count++;
			
			else if (str.charAt(i)=='G' || str.charAt(i)=='g')
				count++;
			
			else if (str.charAt(i)=='C' || str.charAt(i)=='c')
				count++;
			
			else if (str.charAt(i)=='A' || str.charAt(i)=='a')
				count++;
		}
		
		//if the counter that holds how many characters are correct
		//matches the length of the strand then it is a valid strand
		if (count==str.length())
			return true;
		else
			return false;
	}
	
	
    /**
    * Returns the String representation of this DNA object which is the sequence 
    * itself and null if it is a false representation of this DNA object.
    */
	public String toString()
	{
		if(this.isValid()==true)
		{
			return String.valueOf(strand);
		}
		
		else
			return null;
	}

}
