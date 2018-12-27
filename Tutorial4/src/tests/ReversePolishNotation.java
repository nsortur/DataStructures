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

		Double result = 0.0;

		for (int i = 0; i < arr.size(); i++) {

			token = arr.get(i);

			if (token.equals(plus) || token.equals(minus) || token.equals(divide) || token.equals(mult)) {

				Double operandtwo = Double.parseDouble(polish.pop());
				Double operandone = Double.parseDouble(polish.pop());

				if (token.equals(plus)) {
					result = operandtwo + operandone;
				} else if (token.equals(minus)) {
					result = operandone - operandtwo;
				} else if (token.equals(divide)) {
					result = operandone / operandtwo;
				} else if (token.equals(mult)) {
					result = operandone * operandtwo;
				}

				polish.push(Double.toString(result));

			} else {

				polish.push(token);
			}

		}

		result = Double.parseDouble(polish.pop());
		System.out.println(result);
		
		scan.close();
	}
}
