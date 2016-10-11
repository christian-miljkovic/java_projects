package project1;


import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;

 /* *
 * P r o g r a m for t e s t i n g if the d a t a f i l e s can be o p e n e d .
 * T h i s p r o g r a m s i m p l y p r i n t s the c o n t e n t of the f i l e to
 * the c o n s o l e one l i n e at a t i m e .
 * @ a u t h o r J o a n n a K l u k o w s k a
 *
 */
 public class TestFileRead {

 public static void main(String[] args) {

 String fileName = "data/yob1984.txt";
 File f = new File(fileName);

 if (!f.canRead()) {
 System.err.printf("Error: cannot read "
 + "data from file %s" , fileName);
 System.exit(1);
 }

 Scanner inputFile = null;
 try {
 inputFile = new Scanner(f);
 } catch (FileNotFoundException e) {

 System.err.printf("Error: cannot read "
 + "data from file %s" , fileName);
 System.exit(1);
 }

 while (inputFile.hasNextLine()) {
 System.out.println( inputFile.nextLine() );
 }
 inputFile.close(); }

 }