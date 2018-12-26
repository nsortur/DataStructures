package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class myInfiniteAdder {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Node headOne = new Node();
		Node curr = headOne;

		Scanner scanOne = new Scanner(new BufferedReader(new FileReader("num1.txt")));

		while (scanOne.hasNext()) {
			curr.set(scanOne.nextInt());
			curr.setNext(new Node());
			curr = curr.getNext();
		}
		curr = headOne;
		System.out.print("First number: ");

		while (curr.getNext() != null) {
			System.out.print(curr.get());
			curr = curr.getNext();
		}

		Node headTwo = new Node();
		Node curr2 = headTwo;

		Scanner scanTwo = new Scanner(new BufferedReader(new FileReader("num2.txt")));

		while (scanTwo.hasNext()) {
			curr2.set(scanTwo.nextInt());
			curr2.setNext(new Node());
			curr2 = curr2.getNext();
		}

		curr2 = headTwo;
		System.out.print("\nSecond number: ");
		while (curr2.getNext() != null) {
			System.out.print(curr2.get());
			curr2 = curr2.getNext();
		}
		System.out.println("\n");
		
		//////////////////////
		
		curr = headOne;
		curr2 = headTwo;
		
		Node headdub = new Node();
		Node currdub = headdub;
		
		
		
		while(curr.getNext() != null && curr2.getNext() != null) {
			currdub.set(curr.get() + curr2.get());
			curr = curr.getNext();
			curr2 = curr2.getNext();
			currdub.setNext(new Node());
			currdub = currdub.getNext();
		}
		
		currdub = headdub;
		
		System.out.println("Final number: ");
		while(currdub.getNext() != null) {
			System.out.print(currdub.get());
			currdub = currdub.getNext();
		}
	}
}
