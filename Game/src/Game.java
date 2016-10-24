/**
 * This program extends the processing applet in order to create a 
 * game that has the user use their mouse to make a ball object "dodge"
 * a larger ball object, which speeds up and changes directions within a set boundary.
 * 
 * @author christianmiljkovic
 * @version 1.0
 * @since 2016-04-27
 */
import java.awt.geom.Point2D;
import processing.core.PApplet;

public class Game extends PApplet
{
	
	//dimensions of the canvas
	static int xMax = 700;
	static int yMax = 600;
	
	//create the properties for the user ball
	int user_radius = 20; 
	float user_xpos = xMax/2;
	float user_ypos = yMax/2; 	
	
	//this is the speed of the ball that you try to avoid
	static float xStep= 10;
	static float yStep= 10;
	
	//lag between the ball and mouse cursor
	float easing = (float) 1.5; 
	
	//create the properties for the evil ball
	int evil_radius = 60;
	int evil_width = 60;
	int evil_height = 60;

	//state of the game
	int game_state = 0;
	
	//instantiate the "evil" ball
	Ball ball1 = new Ball(evil_radius,evil_width,evil_height);

	
	//set up the screen
	public void setup() 
	{
		size(1000, 700);
		noStroke();
		frameRate(30);
	}
	
	public void draw()
	{
		
		
		//set up the background
		background( 100,100,100);
		size(xMax,yMax);

		//this is the starting screen that explains to the user the rules of the game
		if (game_state==0) 
		{
			
			textSize(32);
			fill(255);
			textAlign(CENTER);
			text("Dodge Ball \n" + "Click Here to Start Dodging",xMax/2 ,yMax/2);
			
			//if the mouse is pressed as explained in the instructions change the game state
			//so that the game starts
			if (mousePressed) 
				game_state=1;
			
		}
		
		//this is the game state where the game is actually played
		else if (game_state==1) 
		{
			
			//these are the instructions for having the ball follow the user's mouse
			float followX = mouseX;
			float change_x = followX - user_xpos;
			user_xpos += change_x * easing;
			
			float followY = mouseY;
			float change_y = followY - user_ypos;
			user_ypos += change_y * easing;
			
			fill(255,0,0);
			ellipse(user_xpos, user_ypos, user_radius*2, user_radius*2);
			
			/*these are the functions that: updates the position of the evil ball,
			 * checks that it stays within the boundary of the screen, speeds 
			 * up the ball after a certain period of time, and checks whether there
			 * was a collision between the user and evil ball
			*/
			ball1.update();
			ball1.checkBoundary();
			fill(225);
			ellipse(ball1.xpos, ball1.ypos, ball1.radius * 2, ball1.radius * 2);
			speedUp(ball1);
			
			//change the game state to game over if there is a collision
			if (checkCollision(ball1)==true)
				game_state=2;
			
		}
		
		//this is the game over state
		else if (game_state==2) 
		{
			textSize(32);
			fill(255);
			textAlign(CENTER);
			text("GAME OVER", xMax/2,yMax/2);
		}
		
		
	}

	/**
	 * Checks to see whether there is a collision between
	 * a Ball object and the user ball.
	 * @param a ball object that would collide with the user ball 
	 * @return true if there was a collision between the two balls
	 *  or false if there isn't a collision.
	 */
	public boolean checkCollision(Ball ball) 
	{
		//convert the position of each ball into double because
		// the distance method takes double for parameters
		double user_xpos = mouseX;
		double user_ypos = mouseY;
		
		double ball_xpos = (double) ball.xpos;
		double ball_ypos = (double) ball.ypos;
		
		//calculate the distance between the two balls with the distance method
		double distance = Point2D.Double.distance(user_xpos, user_ypos, ball_xpos, ball_ypos);
		
		//return true if the distance is less than or equal to the combined radii
		if (distance <= (user_radius + ball.radius))
			return true;
		else
			return false;
	}
	
	/**
	 * Increases the "steps" or speed of the ball that is passed
	 * through the method after a 5 seconds.
	 * @param ball
	 */
	public void speedUp(Ball ball) 
	{
		//increase the speed in the x direction after 5 seconds
		if ((second() % 5) == 0)
		{
			this.xStep += 1;
		}
		
		//increase the speed in the y direction after 5 seconds
		if ((second() % 5) == 0) 
		{
			this.yStep += 1;
		}
	}
	
}




