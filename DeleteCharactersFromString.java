package week3;

import acm.program.ConsoleProgram;

public class DeleteCharactersFromString extends ConsoleProgram{
	
	public void run() {
		String x = "I am in this coding bootcamp";
		char y = 't';
		System.out.println(removeAllOccurrences(x, y));
		}
	
	private String removeAllOccurrences(String str, char ch) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch) {
			result += str.charAt(i);
			}
		}
		return result;
	}
}
