package week5;

import acm.program.GraphicsProgram;
import acm.program.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import acm.graphics.*;


public class BoxDiagram extends GraphicsProgram {
	/* private constants */
	private static final double BOX_WIDTH = 150;
	private static final double BOX_HEIGHT = 120;
	/* private instance variables */
	private JTextField nameField;
	private JButton bntAdd;
	private JButton bntRemove;
	private JButton bntClear;
	private Map<String, GCompound> component = new HashMap<>();
	private int lastY, lastX;
	private GObject lObject;
	
	/*calls mousePressed to get the coordinates of the click. When we click we have the location
	of that object and we're telling it to move from the last location it was to the new location */
	public void mousePressed(MouseEvent e) {
		lastY = e.getY();
		lastX = e.getX();		
		lObject = getElementAt(lastX, lastY);
	}
	//calls mouseDragged to reposition the object.
	public void mouseDragged(MouseEvent e) {
		if (lObject != null) {
			lObject.move(e.getX() - lastX, e.getY() - lastY);
			lastY = e.getY();
			lastX = e.getX();
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		String nameValue = nameField.getText();
		
		if (e.getSource() == nameField) {//if the source of the actionevent is from namefield print the text in the namefield
			System.out.println(nameField.getText());
		}
		
		if (e.getSource() == bntAdd) { 
		if (component.containsKey(nameValue)) {
			return;
		}
			System.out.println(nameField.getText());
			GRect rect = new GRect(50, 80, BOX_WIDTH, BOX_HEIGHT);
			//add(rect);
			GLabel name = new GLabel(nameValue);
			name.setFont("Helvetica-24");
			GCompound box = new GCompound();
			box.add(rect, 0, 0);
			box.add(name, 10, 75); 
			add(box, 20, 75);
			component.put(nameValue, box);
		}
		if (e.getSource() == bntRemove) {
	     if (component.containsKey(nameValue)) {
	    	 GCompound box = component.get(nameValue);
	    	 remove(box);
	    	 component.remove(nameValue);
	     }
		}
		/* for loop is used for iterating entryset() returns a set to store objects that
		 * returns entry, Gcompound. So it removes the map collection and the objects in that collection
		 */
		if (e.getSource() == bntClear) {
			for (Map.Entry<String, GCompound> entry: component.entrySet()) {
				remove(entry.getValue()); //removes the value from the hashmap
				
			}
			component.clear(); //clears the entire canvas if e.getsource == clear
		}
	}
    /* creates the 3 buttons add, remove, clear */
	public void init() {
		
		nameField = new JTextField(10); //adding the jtextfield and telling how many max characters it can hold
		add(new JLabel("Name"), SOUTH); //giving the box a label with the word Name on it
		add(nameField, SOUTH); //adds it to the canvas
		nameField.addActionListener(this); //tells namefield to add action listeners to itself
		
		
		bntAdd = new JButton("Add");  //creating the button named Add
		bntAdd.addActionListener(this); //adds action listeners to the Add button
		add(bntAdd, SOUTH); //adds the Add Button to the south part of the canvas
		bntRemove = new JButton("Remove"); //creating the button named Remove
		add(bntRemove, SOUTH); //adds the Remove Button the south part of the canvas
		bntRemove.addActionListener(this); //adds action listeners to the Remove button
		bntClear = new JButton("Clear"); //creating the button named Clear
		add(bntClear, SOUTH); //adds the Clear button to the south part of the canvas
		bntClear.addActionListener(this); //adds action listeners to the Clear button
		addActionListeners(); //listener interface tracks receiving action events, when event occurs the objects actionPerformed method is invoked 
		addMouseListeners(); //listener interface for tracking the mouse being pressed and released
		
		
	}
}
