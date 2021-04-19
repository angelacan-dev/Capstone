package week2;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.*;
import acm.util.*; //this imports our random generator

public class RandomCircles extends GraphicsProgram {

	/* below we write our constants for the min, max radius and number of circles
	 * and the randomgenerator */
	private static final int NUM_CIRCLES = 10;
	private static final int MIN_RADIUS = 5;
	private static final int MAX_RADIUS = 50;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		
	/* below we create the for loop that will create up to 10 circles
	 * and the double next double returns a random range between 5 and 50
	 */
		for (int i = 0; i < NUM_CIRCLES; i++) {
			double x = rgen.nextDouble(50, 200);
			double r = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
			double y = rgen.nextDouble(100, 400);
	
		
		GOval circles = new GOval(x, y, 2*r, 2*r);
		circles.setFilled(true);
		circles.setColor(rgen.nextColor());
		add(circles);
		}
	}
	
}
