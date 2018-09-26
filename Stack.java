public class Stack{
    Node top;
    
    public void push(Node p){
        p.setNext(top);
        top = p;
        //When pushing onto a stack (putting a new node on top of the stack, which is p), p has to point to the oldTop of the stack. Make it setNext to the top.
        //Then so it points back, make top equal to p. Basically how to push a node onto a stack
    }
    public Node peek(){
        return top;
    }
    //the point of this is to
    public Node pop(){
        //needs an oldTop to point to before setting top to next
        Node oldTop = top;
        //sets top equal to the next part of the linked list (or stack)
        top = top.getNext();
        //gets rid of link, because setnext makes the pointer, doesn't set the value of the next node unless a new node is made
        oldTop.setNext(null);
        return oldTop;
    }
}
/**
 * if "(", push something
 * if ")" pop
 * If you try to pop but the top is null, there are too many ")"
 * If you reach the end and the stack is not empty, there are too many "("
 */