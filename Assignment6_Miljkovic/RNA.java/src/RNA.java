
public class RNA {
	private String strand="";

	
	public RNA(String strand) {
		this.strand=strand;
		
	}
	
	public String toProtein( int position ){
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
		
		if (position < 0 | position > this.strand.length()-1)
			return null;
		else if (this.isValid()==false)
			return null;
		else if(this.strand.length()==0 | this.strand.length()<3)
			return null;
		
		//create an array in order to split the RNA strand into its codons
		String[] RNAcodons=new String[(this.strand.length()-position)/3];
		
		//holding variables for counting the amount of codons and holding the codons
		String single_codon="";
		int count=0;
		int index=0;
		
		//use a for loop to fill in the RNAcodons array every three characters
		for (int i=position; i < this.strand.length(); i++){
			if(count<3)
				single_codon+=this.strand.charAt(i);
			//count how many characters are looped through in order to organize the strand into codons
			count++;
			
			if(count==3){
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
		for (int i=0; i < RNAcodons.length; i++){
			
			//run through the codons array
			for(int row=0; row < codons.length; row++) {
				for(int col=0; col < codons[row].length; col++){
					
					if (RNAcodons[i].equals(codons[row][col]))
						//set the index if you find a correct sequence that matches 
						proteinIndex[i]=row;
				}
			}
		}
		
		String proteins_sequence="";
		
		for (int i=0; i < proteinIndex.length; i++){
			if (proteins[proteinIndex[i]].equals("stop"))
				break;
			else
				proteins_sequence+=proteins[proteinIndex[i]];
		}
		
		if(proteins_sequence.length()==0)
			return null;
		
		return proteins_sequence;
		
	}
	
	private boolean isValid() {
		int count=0;
		String str = this.strand;
		for (int i=0; i < str.length(); i++){
			if (str.charAt(i)=='U' | str.charAt(i)=='G' | str.charAt(i)=='C' | str.charAt(i)=='A')
				count++;
		}
		if (count==str.length())
			return true;
		else
			return false;
	}
	
	public String toString() {
		if(this.isValid()==true){
			return String.valueOf(strand);
		}
		else
			return null;
	}
	
	
	
}
