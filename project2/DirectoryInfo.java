package project2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class parses and validate command line arguments and display the results
 * accordingly. The program then uses a recursive method to determine the size
 * of the directory, and then stores information about all of the regular files.
 * The program then displays the total size and the total number of files found
 * in the user specified directory. It then displays a list of twenty (or fewer,
 * if there are fewer than 20 files in total) largest/oldest/newest files found.
 * 
 * @author christianmiljkovic
 *
 */
public class DirectoryInfo {
	// create an ArrayList in order to hold all the visited files
	static ArrayList<FileOnDisk> disk_files = new ArrayList<FileOnDisk>();

	// use the total size in order to determine how many files will be output
	static long total_size = 0;

	public static void main(String[] args) {

		// Validate the input from the command line and make sure
		// that there are two arguments if not exit
		if (args.length < 2) {
			System.err.print("Error: Two Strings Required.");
			System.exit(0);
		}

		// create the File object in order to hold the directory path provided
		File dir = new File(args[0]);

		// check to make sure that the path inputed exists
		if (!(dir.exists())) {
			System.err.print("Error: Path Provided Does Not Exist.");
			System.exit(0);
		}

		// check to make sure that the path inputed is valid
		// check first directory then file
		if (!(dir.isDirectory())) {
			if (!(dir.isFile())) {
				System.err.print("Error: Invalid Path Provided.");
				System.exit(0);
			}
		}

		// keep track of what the second input is to determine which methods we
		// have to use
		String choice = null;

		// check to make sure that the second input is valid
		// set the choice variable from above to the second input based upon the
		// second argument
		// in order to determine which operation to perform
		if (args[1].equalsIgnoreCase("largest"))
			choice = "largest";

		else if (args[1].equalsIgnoreCase("oldest"))
			choice = "oldest";

		else if (args[1].equalsIgnoreCase("newest"))
			choice = "newest";

		else {
			System.err.print("Error: This option is not supported.");
			System.exit(0);
		}

		// use a try catch block in order to prevent any IOExceptions
		// get the total size of the directory and use the method getSize to do
		// so
		try {
			total_size = getSize(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create the conversions of the size of each file
		double bytes = total_size;
		double kilo_bytes = bytes / 1024;
		double mega_bytes = kilo_bytes / 1024;
		double giga_bytes = mega_bytes / 1024;

		// use this variable to set either to bytes,KB,MB,and GB for when you
		// print the output
		String print_byte;
		double print_size;

		// use an if-else statement in order to determine which size should be
		// printed
		// if the unit is greater than 1 use that unit i.e. GB > 1 we know that
		// we have
		// a large enough file that it should be labled using GB
		if (giga_bytes > 1) {
			print_byte = "GB";
			print_size = giga_bytes;
		}

		else if ((mega_bytes > 1)) {
			print_byte = "MB";
			print_size = mega_bytes;
		}

		else if ((kilo_bytes > 1)) {
			print_byte = "KB";
			print_size = kilo_bytes;
		}

		else {
			print_byte = "bytes";
			print_size = bytes;
		}

		// use printf in order to format the output found above
		System.out.printf("Total Space Used: %6.2f %s,\t Total Number of Files: %,d \n", print_size, print_byte,
				disk_files.size());

		// based upon the choice input from the console return either
		// largest,newest, or oldest files

		// use an if-else statement in case there are not 20 or more files
		if (disk_files.size() < 20) {

			// if the option is largest then sort the disk_files by size and
			// output the largest files
			if (choice.equals("largest")) {
				System.out.println("Largest " + disk_files.size() + " files:");
				Collections.sort(disk_files, new CompareFilesBySize());

				// loop through the array list disk_files from the back because
				// that is where the largest ones are
				for (int i = disk_files.size() - 1; i >= 0; i--) {
					// print out the individual file
					System.out.println(disk_files.get(i).toString());
				}
			}

			// if the option is newest then sort the disk_files by date modified
			// and output the newest files
			else if (choice.equals("newest")) {
				System.out.println("Most recently modified " + disk_files.size() + " files:");
				Collections.sort(disk_files, new CompareFilesByDate());

				// loop through the array list disk_files from the back because
				// that is where the newest ones are
				for (int i = disk_files.size() - 1; i >= 0; i--) {
					System.out.println(disk_files.get(i).toString());
				}
			}

			// if the option is oldest then sort the disk_files by date modified
			// and output the newest files
			else if (choice.equals("oldest")) {
				System.out.println("Least recently modified " + disk_files.size() + " files:");
				Collections.sort(disk_files, new CompareFilesByDate());

				// loop through the array list disk_files from the front because
				// that is where the oldest ones are
				for (int i = 0; i < disk_files.size(); i++) {
					System.out.println(disk_files.get(i).toString());
				}
			}
		}

		// use an else statement in case there are 20 or more files
		else {

			// if the option is largest then sort the disk_files by size and
			// output the largest files
			if (choice.equals("largest")) {
				System.out.println("Largest 20 files:");
				Collections.sort(disk_files, new CompareFilesBySize());

				// loop through the array list disk_files from the back because
				// that is where the largest ones are
				for (int i = disk_files.size() - 1; i >= disk_files.size() - 20; i--) {
					System.out.println(disk_files.get(i).toString());
				}
			}

			// if the option is newest then sort the disk_files by date modified
			// and output the newest files
			else if (choice.equals("newest")) {
				System.out.println("Most recently modified 20 files:");
				Collections.sort(disk_files, new CompareFilesByDate());

				// loop through the array list disk_files from the back because
				// that is where the newest ones are
				for (int i = disk_files.size() - 1; i >= disk_files.size() - 20; i--) {
					System.out.println(disk_files.get(i).toString());
				}
			}

			// if the option is oldest then sort the disk_files by date modified
			// and output the newest files
			else if (choice.equals("oldest")) {
				System.out.println("Least recently modified 20 files:");
				Collections.sort(disk_files, new CompareFilesByDate());

				// loop through the array list disk_files from the front because
				// that is where the oldest ones are
				for (int i = 0; i <= 20; i++) {
					System.out.println(disk_files.get(i).toString());
				}
			}
		}

	}

	/**
	 * This method recursively runs through the directory provided by the File
	 * object and its pathname. It also checks to make sure that symbolic links
	 * do not lead to infinite recursive calls, and adds the individual files
	 * found to the ArrayList disk_files.
	 * 
	 * @param directory_name:
	 *            a File object that represents the path name to a directory
	 * @return long: total_size which is the total size (number of bytes used on
	 *         the disk) of the directory provided by the path name
	 * @throws IOException
	 */
	public static long getSize(File directory_name) throws IOException {
		int total_size = 0;

		// check to see if there are symbolic links
		if (!(directory_name.getCanonicalPath().equals(directory_name.getAbsolutePath()))) {

			// if they are symbolic links return the total size if the path is a
			// directory
			if (directory_name.isDirectory())
				return total_size;

			// return the total size if the path is a file
			if (directory_name.isFile())
				// disk_files.add()
				return total_size;

		}

		// check if the path is to a directory
		if (directory_name.isDirectory()) {

			// add size of the directory and find the list of files and
			// subdirectory within it
			total_size += directory_name.length();
			File[] list_of_files = directory_name.listFiles();

			// run through each file or subdirectory and add to total size if it
			// is a file
			for (int i = 0; i < list_of_files.length; i++) {

				// call getSize recursively in order to recursively get to the
				// base cases
				// this will continue until the path leads to a file
				total_size += getSize(list_of_files[i]);

			}
		}

		// when you determine that the path leads to a file add the size to the
		// total size
		else {
			total_size += directory_name.length();
			FileOnDisk new_file = new FileOnDisk(directory_name.getAbsolutePath());
			disk_files.add(new_file);
		}

		return total_size;

	}

}
