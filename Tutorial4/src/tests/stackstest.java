package tests;

import java.util.Scanner;

public class stackstest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		Stack parenthesis = new Stack();

		String open = "(";
		String closed = ")";

		for (int i = 0; i < line.length(); i++) {

			String part = line.substring(i, i + 1);

			if (part.equals(open)) {
				parenthesis.push(new Node());

			} else if (part.equals(closed)) {
				if (parenthesis.peek() == null) {
					System.out.println("There are too many closed parenthesis!");
					return;

				} else {
					parenthesis.pop();
				}
			}

		}
		if (parenthesis.peek() == null) {
			System.out.println("Perfect parenthesis!");
		} else {
			System.out.println("There are too many open parenthesis!");
		}
	}
	

}
