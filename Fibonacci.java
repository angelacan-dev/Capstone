package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	public static void main(String[] args) {
	int MAX_VALUE = 10000, X = 0, Y = 1;
		

		System.out.print("This program lists the Fibonacci Sequence ");
			while(X < MAX_VALUE)
			{
				System.out.print(X+" ");
						int Z = X + Y;
					    X = Y;
						Y = Z;
			}
	}
}
