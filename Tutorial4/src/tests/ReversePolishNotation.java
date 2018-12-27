package tests;

import java.util.Scanner;
import java.io.*;

public class ReversePolishNotation {
	public static void main(String[] args) throws Exception {

		Stack polish = new Stack();
		Scanner scan = new Scanner(new BufferedReader(new FileReader("polish.txt")));
		String line = scan.nextLine();

		String plus = "+";
		String minus = "-";
		String divide = "/";
		String mult = "*";
		
		int result = 0;

		boolean pending = true;

		for (int i = 0; i < line.length(); i++) {
			String token = line.substring(i, i + 1);

			if (token.equals(plus) || token.equals(minus) || token.equals(divide) || token.equals(mult)) {
				int operandtwo = Integer.parseInt(polish.pop());
				int operandone = Integer.parseInt(polish.pop());

				result = Integer.valueOf(operandtwo + token + operandone);

				polish.push(Integer.toString(result));

			} else {

				polish.push(token);
			}

		}
		
		result = Integer.parseInt(polish.pop());
		System.out.println(result);
	}
}
