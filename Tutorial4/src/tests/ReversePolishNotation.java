package tests;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class ReversePolishNotation {
	public static void main(String[] args) throws Exception {

		Stack polish = new Stack();
		Scanner scan;
		scan = new Scanner(new BufferedReader(new FileReader("polish.txt")));
		String token = "";

		ArrayList<String> arr = new ArrayList<String>();

		while (scan.hasNext()) {
			arr.add(scan.next());
		}

		String plus = "+";
		String minus = "-";
		String divide = "/";
		String mult = "*";

		int result = 0;

		for (int i = 0; i < arr.size(); i++) {

			token = arr.get(i);

			if (token.equals(plus) || token.equals(minus) || token.equals(divide) || token.equals(mult)) {

				int operandtwo = Integer.parseInt(polish.pop());
				int operandone = Integer.parseInt(polish.pop());

				if (token.equals(plus)) {
					result = operandtwo + operandone;
				} else if (token.equals(minus)) {
					result = operandone - operandtwo;
				} else if (token.equals(divide)) {
					result = operandone / operandtwo;
				} else if (token.equals(mult)) {
					result = operandone * operandtwo;
				}

				polish.push(Integer.toString(result));

			} else {

				polish.push(token);
			}

		}

		result = Integer.parseInt(polish.pop());
		System.out.println(result);
	}
}
