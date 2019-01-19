public class Node
{
    String value;
    Node next;
    
    public Node(String v) {
    	value = v;
    }

    public String get() {
        return value;
    }
    public void set(String v) {
        value = v;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node n) {
        next = n;
    }
}