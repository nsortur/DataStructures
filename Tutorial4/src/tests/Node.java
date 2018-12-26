package tests;

public class Node {

	int value;
	Node next;
	
	
	
	public int get() {
		return value;
	}

	public void set(int v) {
		value = v;
	}

	public Node getNext() {
		return next;
	}
	
	
	public void setNext(Node n) {
		next = n;

	}
}
