/**
 * This class creates an object called Rectangle that has the properties of a rectangle using the height and width.
 * @author christianmiljkovic
 * @version 03/23/16
 *
 */

class Rectangle 
{
	
	private double height = 0;
	private double width = 0;
	
	//create a default Rectangle
	Rectangle() 
	{
		height=1;
		width=1;
	}
	
	//create a constructor that makes a specific rectangle 
	Rectangle (double newHeight, double newWidth) 
	{
		height= newHeight;
		width= newWidth;
	}
	
/**
 * This method allows the user to set a new height from the default
 * @param newHeight of the double type
 */
	void setHeight(double newHeight) 
	{
		//set the height to the new height
		height= newHeight;
	}
	
/**
 * This method allows the user to set a new width from the default
 * @param newWidth of the double type
 */
	void setWidth(double newWidth) 
	{
		//set the width to the new width
		width= newWidth;
	}
/**
 * This method gives the user the height of the rectangle	
 * @return: width of rectangle of double type
 */
	double getHeight()
	{
		return height;
	}
/**
 * This method gives the user the width of the rectangle	
 * @return: width of rectangle of double type 
 */
	double getWidth() 
	{
		return width;
	}
	
/**
 * This method takes the height and width of a rectangle and calculates the area
 * @return: the area of a rectangle in the double type
 */
	double getArea() 
	{
		//calculate the area of a rectangle
		return height*width;
	}
	
/**
 * This method takes the height and width of a rectangle and calculates the perimeter
 * @return: the perimeter of a rectangle in the double type
 */
	double getPerimeter() 
	{
		//calculate the perimeter of a rectangle
		return 2*height + 2*width;
	}

}
