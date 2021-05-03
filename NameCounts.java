package week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import acm.program.ConsoleProgram;

/*this program asks user to enter a name then counts how many times that name is entered*/
public class NameCounts extends ConsoleProgram {
	
	public void run() {
		Map<String, Integer> nameCount = new HashMap<>(); //Hashmap is used to store. String (name) is our key, Integer is our value
		Scanner scanner = new Scanner(System.in); //Scanner reads the line
		
		/*while loop is initiated so that it continues to ask user to enter a name until user hits enter */
		while(true) {
			System.out.print("Enter a name: ");
			String name = scanner.nextLine();
			//System.out.println("Name: " + name);
			if("".equals (name)) {
				break;
			}
	
			if(nameCount.containsKey(name)) {
				int count = nameCount.get(name); 
				nameCount.put(name, count + 1); //if name is already stored add 1 to the count
			}
			else {
				nameCount.put(name, 1); //else store name in the hashmap
			}
		}
		for (Map.Entry<String, Integer> nc: nameCount.entrySet()) {
			System.out.println("Entry [ "+ nc.getKey()+"] has count " + nc.getValue() );
		}
	
	}
	
}