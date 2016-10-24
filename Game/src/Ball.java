/**
 * This class creates a Ball object with a specific 
 * radius, x-position, and y-position that is used for Game.java.
 * 
 * @author christianmiljkovic
 * @version 1.0
 * @since 2016-04-27
 */
import processing.core.PApplet;
public class Ball extends PApplet
{
	
	//the ball properties
	int radius;
	float xpos,ypos;
	
	//the constructor that takes specific inputs
	Ball (int radius, float xpos, float ypos) 
	{
		
		//set the properties of the ball
		this.radius = radius;
		
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	/**
	 * This method takes the x and y position of a ball object
	 * and checks whether it hits a "wall" in the processing screen. If it touches 
	 * a wall it then bounces back.
	 */
	public void checkBoundary() 
	{
		//check the x position of the ball compared to the x boundary
		if (this.xpos >= Game.xMax || this.xpos <= 0 )
			Game.xStep = -Game.xStep;
		
		//check the y position of the ball compared to the y boundary
		if (this.ypos >= Game.yMax || this.ypos <= 0 )
			Game.yStep = -Game.yStep;
	}
	
	/**
	 * This method continuously updates the position of the ball object
	 * in order to make it look like the ball is moving smoothly in the processing
	 * screen.
	 */
	void update() 
	{
		this.xpos = this.xpos+Game.xStep;
		this.ypos = this.ypos+Game.yStep;
	}
	
	
}
