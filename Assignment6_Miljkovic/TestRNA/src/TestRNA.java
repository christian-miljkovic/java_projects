/**
 * The TestRNA class tests the RNA and DNA classes by seeing if they create
 * valid strands of DNA, RNA, and then Protein.
 * 
 * @author christianmiljkovic
 * @version 1.0
 * @since 2016-04-12
 */

import java.util.Scanner;
public class TestRNA {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your DNA sequence: ");
		String dna_sequence= input.nextLine();
		
		
		//create a DNA object then convert it to an RNA Strand
		//Convert the RNA strand to a Protein strand
		DNA dna1 = new DNA(dna_sequence);
		
		RNA rna1 = new RNA(dna1.toRNA());
		
		System.out.println("The RNA Strand " + rna1);
		System.out.println("This is the protein " + rna1.toProtein(0) );
	}

}

