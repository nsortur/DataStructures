package tests;

public class Stack {
	
		Node top;

		public void push(Node n) {
			n.setNext(top);
			top = n;
		}

		public Node pop() {
			if (top == null) {
				return null;
			}
			Node ret = top;
			top = top.getNext();
			ret.setNext(null);
			return ret;
		}

		public Node peek() {
			return top;
		}
	
}
