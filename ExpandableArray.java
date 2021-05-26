package week6;

import acm.program.ConsoleProgram;

public class ExpandableArray extends ConsoleProgram {
private Object[] array;
	
	public void run() {
			array = new Object[0]; 
		}
	/*sets the element at the given index position to the specified value. If the internal array is not large enough
	to contain that element, the application expands the array to make room for it*/
	public void set(int index, Object value) {
		if (index >= array.length) {
			
			Object[] newArray = new Object[index + 1]; //create new array that is large enough
			
			for (int i = 0; i < array.length; i++) { //copy all existing elements into new array
				newArray[i] = array[i];
			}
			//keeps track of the new array in place of the old array
			array = newArray;
		} 
		array[index] = value;	
	}
	/* returns the element at the specified index position, or null if no such element exists. If the index is
	 * outside the bounds of the array, the return value is simply null.
	 */
	public Object get(int index) {
		if (index >= array.length) return null;
		return array[index];
	}

	}
	
