package week3;

import acm.program.ConsoleProgram;

public class AddCommasToNumberStrings extends ConsoleProgram {
	
	public void run() {
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}
	

	private String addCommasToNumericString(String digits) {
		int len = digits.length();
		String result = "";
		int num = 0;
		for (int i = len -1; i >=0; i--)
		{
			result = digits.charAt(i) + result;
			num++;
			if((num % 3 ==0) && (i>0)) {
				result = "," + result;
			}
		}
		return result;
	}
}