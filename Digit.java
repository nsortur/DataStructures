public class Digit
{
    int digit;
    Digit next;
    Digit prev;
    int current;
    
    public int getDigit() {
        return digit;
    }
    public void setDigit(int d) {
        digit = d;
    }
    public Digit getNext() {
        return next;
    }
    public void setNext(Digit d) {
        next = d;
    }
    public Digit getPrev() {
        return prev;
    }
    public void setPrev(Digit d) {
        prev = d;
    }
    public Digit(int current)
    {
        this.current = current;
    }
}