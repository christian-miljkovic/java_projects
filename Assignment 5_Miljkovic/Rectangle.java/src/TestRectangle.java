/**
 * This class tests an object called Rectangle that has the properties of a rectangle using the height and width.
 * @author christianmiljkovic
 * @version 03/23/16
 *
 */

public class TestRectangle 
{
	
	public static void main(String[] args) 
	{
		//create a default Rectangle object
		Rectangle rec1 = new Rectangle ();
		System.out.printf("rectangle 1:" + "\n %-12s %.3f x %.3f"
			      + "\n %-12s %.3f"
			      + "\n %-12s %.3f\n\n",
			      "dimensions:", rec1.getWidth() , rec1.getHeight(),
			      "area:", rec1.getArea(), "perimeter:", rec1.getPerimeter());
		
		// create a default Rectangle object //and then set values of width and height
		Rectangle rec2 = new Rectangle () ; rec2.setWidth(3.33333333); rec2.setHeight(5.1); System.out.printf("rectangle 2:"
		    + "\n %-12s %.3f x %.3f"
		    + "\n %-12s %.3f"
		    + "\n %-12s %.3f\n\n",
		    "dimensions:", rec2.getWidth() , rec2.getHeight(),
		    "area:", rec2.getArea(), "perimeter:", rec2.getPerimeter());
		// create a Rectangle object using 2-param constructor

		Rectangle rec3 = new Rectangle (13.7, 2.3) ; System.out.printf("rectangle 2:"
		    + "\n %-12s %.3f x %.3f"
		    + "\n %-12s %.3f"
		    + "\n %-12s %.3f\n\n",
		    "dimensions:", rec3.getWidth() , rec3.getHeight(),
		    "area:", rec3.getArea(), "perimeter:", rec3.getPerimeter());
		
	}
	
}
