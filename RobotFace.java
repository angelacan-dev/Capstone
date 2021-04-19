package week2;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;

//* the following program creates a robotface to the canvas*//
public class RobotFace extends GraphicsProgram {
	
private static final int HEAD_WIDTH = 200;
private static final int HEAD_HEIGHT = 300;
private static final int EYE_RADIUS = 50;
private static final int MOUTH_WIDTH = 100;
private static final int MOUTH_HEIGHT = 50;

public void run() {
	GRect rect = new GRect(50, 80, HEAD_WIDTH, HEAD_HEIGHT);
	rect.setFilled(true);
	rect.setFillColor(Color.GRAY);
	add(rect);

	//*the code below draws the eyes of the robot face*//
	GOval leftEye = new GOval (EYE_RADIUS, 50);
	leftEye.setFilled(true);
	leftEye.setFillColor(Color.YELLOW);
	add(leftEye);
	leftEye.setLocation(80,100);
	
	GOval rightEye = new GOval (EYE_RADIUS, 50);
	rightEye.setFilled(true);
	rightEye.setFillColor(Color.YELLOW);
	add(rightEye);
	rightEye.setLocation(180,100);
	
	//*the code below draws the mouth of the robot face*//
	GRect mouthRect = new GRect(100, 150, MOUTH_WIDTH, MOUTH_HEIGHT);
	mouthRect.setFilled(true);
	mouthRect.setFillColor(Color.WHITE);
	add(mouthRect);
	mouthRect.setLocation(100, 250);
	}
}