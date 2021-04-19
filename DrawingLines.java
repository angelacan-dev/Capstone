package week2;
import java.awt.event.MouseEvent;

import acm.program.GraphicsProgram;
import java.awt.event.*;
import acm.graphics.*;


public class DrawingLines extends GraphicsProgram {
	
   /* public void init method starts an JApplet */
	public void init() {
		addMouseListeners();
	}
	
	/* the mousePressed method is called after every time a mouse button is pressed*/
	public void mousePressed(MouseEvent i) {
		line = new GLine(i.getX(), i.getY(), i.getX(), i.getY());
		add(line);
	}
	
	/* this method is invoked when the mouse button is released*/
	public void mouseReleased(MouseEvent i) {
		line.setEndPoint(i.getX(), i.getY());
	}

	private GLine line;
}
