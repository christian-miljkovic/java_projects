package project2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * This class creates a FileOnDisk object that represents a file on a users
 * disk. This object inherits from File class from Java API and it provides its
 * own toString() method that returns a String object that is formatted.
 * 
 * @author christianmiljkovic
 *
 */
public class FileOnDisk extends File {

	FileOnDisk(String pathname) {
		super(pathname);
	}

	/**
	 * This to string method takes the FileOnDisk's pathname and retrieves its
	 * size, date of last modification and pathname in order to format them into
	 * a single output for an individual file on a users disk. Furthermore, the
	 * Date and SimpleDateFormat classes are used in order to help format the
	 * date of last modification of each file.
	 * 
	 * @return String that represents the size of the file, date that it was
	 *         modified, and its pathname.
	 */
	@Override
	public String toString() {

		// get the information about the file that will be output later
		long last_modified = this.lastModified();

		// create the conversions
		double bytes = this.length();
		double kilo_bytes = bytes / 1024;
		double mega_bytes = kilo_bytes / 1024;
		double giga_bytes = mega_bytes / 1024;

		// use this variable to set either to bytes,KB,MB,and GB
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

		// create the date object in order to format it
		Date date_modify = new Date(last_modified);

		// format the date using the SimpleDateFormat class
		SimpleDateFormat format_date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String clean_date = format_date.format(date_modify);

		// format the string in order to maintain the same output
		return String.format("%6.2f %-6s %s %s", print_size, print_byte, clean_date, this.getAbsolutePath());

	}

}

/**
 * This is a Comparator class that Compares FileOnDisk by the File size. This
 * class is later used in order to perform a Collections.sort()
 * 
 * @author Joanna Klukowska
 *
 */
class CompareFilesBySize implements Comparator<FileOnDisk> {

	@Override
	public int compare(FileOnDisk o1, FileOnDisk o2) {
		int comp = (int) (o1.length() - o2.length());
		if (comp == 0) {
			return o1.compareTo(o2);
		}
		return comp;
	}

}

/**
 * This is a Comparator class that Compares FileOnDisk by the File's last date
 * of modification. This class is later used in order to perform a
 * Collections.sort()
 * 
 * @author Joanna Klukowska
 *
 */
class CompareFilesByDate implements Comparator<FileOnDisk> {
	@Override
	public int compare(FileOnDisk o1, FileOnDisk o2) {
		long comp = o1.lastModified() - o2.lastModified();

		if (comp == 0) {
			return o1.compareTo(o2);
		}

		if (comp > 0)
			return 1;
		else
			return -1;
	}
}
