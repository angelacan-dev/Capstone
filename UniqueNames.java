package week4;

import java.util.ArrayList;
import acm.program.ConsoleProgram;

public class UniqueNames extends ConsoleProgram {
	
	public void run() {
		ArrayList<String> sList = new ArrayList<String>();
		
		while (true) {
			String line = readLine("Enter a name: ");
			if (line.equals("")) break;
				if(!sList.contains(line)) {
			sList.add(line); 

		}
	}
	for (int i = 0; i < sList.size(); i++) {
		System.out.println("Unique name list contains: " + sList.get(i));

}
	}	
}