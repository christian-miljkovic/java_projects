/* Christian Miljkovic 02/22/16
 * This program asks the user whether they want to encrypt or decrypt
 * a message (that they input) and then asks for the key (negative or positive) to the encryption/decryption
 * so that the two methods encryptor and decryptor can either encrypt or decrypt their message
 * based upon the input given.
*/

import java.util.Arrays;
import java.util.Scanner;
public class EncryptDecrypt 
{

	public static void main(String[] args) 
	{
	//print out the main menu greeting the user
	System.out.println("====================");
	System.out.println("Encrypt/Decrypt Tool");	
	System.out.println("====================\n");
	
	//ask the user whether they want to encrypt or decrypt 
	Scanner input = new Scanner(System.in);
	System.out.print("What would you like to do? (E)ncrypt or (D)ecrypt?: ");
	String answer = input.nextLine();
	

	//use this array in order to compare the answer given and see if it is valid
	String[] dataVal= {"e","E","d","D","x"};
	
	int counter=0; //if the counter variable is greater than 4 this will indicate that the user did not give a correct input
	//use a for loop to loop through the array and compare the answer
	for (int i=0; i<dataVal.length; i++) 
	{
		//if the answer is within the array exit the loop 
		if (answer.equals(dataVal[i])==true)
			break;
		
		//since we know there are only 4 right answers if there are 4 false ones we know that
		//the user did not give the program a correct input
		else if (answer.equals(dataVal[i])==false)
			counter+=1;
		
		//this was meant so that the out of index error would not occur
		if (answer.equals("x")) 
		{
			System.out.print("\nError: invalid choice.");
			System.exit(0); 
		}
		
		//again if there are 4 falses we have an invalid answer 
		if (counter==4) 
		{
			System.out.print("\nError: invalid choice.");
			System.exit(0);
		}
		
	}
	
	
	//for formatting
	System.out.print("\n");
	
	//ask the user for the encryption key
	Scanner input2 = new Scanner(System.in);
	System.out.print("Enter your encryption key: ");
	int key = input2.nextInt();
	
	
	//make sure using if statements that the key input is within the range -26<key<26
	if (key>26) 
	{
		System.out.print("\nError: invalid number.");
		System.exit(0);
	}
	
	if (key<-26) 
	{
		System.out.print("\nError: invalid number.");
		System.exit(0);
	}
	
	
	
	//formating
	System.out.print("\n");
	
	//ask the user for the message that they want to encyprt/decrypt
	Scanner input3 = new Scanner(System.in);
	System.out.print("Enter your message: ");
	String message = input3.nextLine();
	
	//formatting
	System.out.print("\n");
	
	
	//use this if-else if statement in order to choose which method to use based upon the answer given
	if (answer.equals("E"))
		encyrptor(message,key);
		
	else if (answer.equals("e"))
		encyrptor(message,key);
		
	else if (answer.equals("D"))
		decryptor(message,key);
		
	else if (answer.equals("d"))
		decryptor(message,key);
	
	
	
	}

	
	
	//this method takes the two inputs from the user (message) in the form of a String
	//and (key) in the form of int and then uses the key to shift the alphabet array then 
	//encrypts the message
	//the key deteremines which way and how many letters in the alphabet are shifted for the encryption
	public static void encyrptor(String message, int key) 
	{
		//provide the array of characters that we need and the holding variables for the cipher message
		char[] plainList = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] capitalList= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] cipherList = new char[27];  //for lowercase letters
		char[] cipherList2 = new char[27]; //for capital letters
		String cipherMessage="";
		char nonLetter = 0;
		
		//use an if statement if the key is negative
		if (key>=0) 
		{
			//this switches the letters from the shifted key
			for (int i=0; i<plainList.length - key; i++)
			{
				cipherList[i]=plainList[key+i];
				cipherList2[i]=capitalList[key+i];
				
			}
			
			//this fills in the last letters at the end of the array
			for (int i=0; i<key; i++) 
			{
				cipherList[cipherList.length-key-1+i]=plainList[i];
				cipherList2[cipherList2.length-key-1+i]=capitalList[i];
			}
		}
		
		//this is if the key is negative
		else if (key<0) 
		{
			int posKey= -1*key; //easier to work with a positive key
			
			//this gives us the first letters in the array
			for (int i=0; i<posKey; i++)
			{
				cipherList[i]=plainList[plainList.length-posKey+i];
				cipherList2[i]=capitalList[plainList.length-posKey+i];
			}
			
			//this gives us the rest of the letters in the array
			for (int i=0; i<plainList.length-posKey;i++) 
			{
				cipherList[i+posKey]=plainList[i];
				cipherList2[i+posKey]=capitalList[i];
			}
		}
		//now to create the encrypted message
		//use a for loop in order to loop through each char in the message and compare it
		//to alphabet array where you then get the index which allows you to index the array
		//that has the shifted alphabet or is the encrypted equivalent
		for (int i=0;i<message.length();i++) 
		{
			
			//if the character is capital use the capital array
			if (Character.isUpperCase(message.charAt(i))==true) 
			{
				//use this for loop to find the corresponding encrypted letter
				for (int j = 0; j<capitalList.length-1;j++) 
				{
					if (message.charAt(i)==(capitalList[j]))
					{
						cipherMessage+=cipherList2[j]; //add the chars to the cipher message
					}
				}
			}
			//same process but just if it is a lowercase letter
			else if (Character.isLowerCase(message.charAt(i))==true) 
			{	
				for (int j = 0; j<plainList.length-1;j++) 
				{
					if (message.charAt(i)==(plainList[j]))
					{
						cipherMessage+=cipherList[j]; //add the chars to the cipher message
					}
				}

			}
			//use this in order to add in the chars that aren't letters
			else 
			{
				nonLetter = message.charAt(i);
				cipherMessage+=nonLetter; 
			}

		}
		//print out the output
		System.out.print("Your encrypted message is: " + cipherMessage);
    }
	
	
	
	
	
	
	//this method takes the two inputs from the user decrypted (message) in the form of a String
	//and (key) in the form of int and then uses the key to shift the alphabet array then 
	//decrypts the message
	//the key deteremines which way and how many letters in the alphabet are shifted for the decryption
	public static void decryptor(String message, int key) 
	{
		//provide the array of characters that we need and the holding variables such as decipherMessage
		char[] plainList = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] capitalList= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] cipherList = new char[27];  //for lowercase letters
		char[] cipherList2 = new char[27]; //for capital letters
		String decipherMessage="";
		char nonLetter = 0;
		
		//this is if the key is positive
		if (key>=0) 
		{
			//this switches the letters from the shifted key
			for (int i=0; i<plainList.length - key; i++)
			{
				cipherList[i]=plainList[key+i];
				cipherList2[i]=capitalList[key+i];
				
			}
			
			//this fills in the last letters at the end of the array
			for (int i=0; i<key; i++) 
			{
				cipherList[cipherList.length-key-1+i]=plainList[i];
				cipherList2[cipherList2.length-key-1+i]=capitalList[i];
			}
		}
		//this is if the key is negative
		else if (key<0) 
		{
			int posKey= -1*key; //easier to work with a positive key
			
			//this gives us the first letters in the array
			for (int i=0; i<posKey; i++)
			{
				cipherList[i]=plainList[plainList.length-posKey+i];
				cipherList2[i]=capitalList[plainList.length-posKey+i];
			}
			
			//this gives us the rest of the letters in the array
			for (int i=0; i<plainList.length-posKey;i++) 
			{
				cipherList[i+posKey]=plainList[i];
				cipherList2[i+posKey]=capitalList[i];
			}
		}
		//now to create the decrypted message
		//use a for loop in order to loop through each char in the decrypted message and compare it
		//to regular alphabet array where you then get the index which allows you to index the array
		//that has the shifted alphabet or is the encrypted equivalent
		for (int i=0;i<message.length();i++) 
		{
			
			//this is if the char is uppercase
			if (Character.isUpperCase(message.charAt(i))==true) 
			{
				//use a for loop to find the encrypted equivalent of the char in uppercase alphabet arrary
				for (int j = 0; j<cipherList2.length-1;j++) 
				{
					if (message.charAt(i)==(cipherList2[j]))
					{
						decipherMessage+=capitalList[j];
					}
				}
			}
			//this is if the char is lowercase
			else if (Character.isLowerCase(message.charAt(i))==true) 
			{	
				//use a for loop to find the encrypted equivalent of the char in lowercase alphabet array
				for (int j = 0; j<cipherList.length-1;j++) 
				{
					if (message.charAt(i)==(cipherList[j]))
					{
						decipherMessage+=plainList[j]; //add the decrypted char to the deciphered message
					}
				}

			}
			//use this in order to add in the chars that aren't letters
			else 
			{
				nonLetter = message.charAt(i);
				decipherMessage+=nonLetter; 
			}

		}
		//print out the output
		System.out.print("Your decrypted message is: " + decipherMessage); 
    } 
	}	

