import java.util.Scanner;
import java.io.*;
public class ParenCount{
    public static void main(String[] args) throws Exception {
        Stack tracker = new Stack();
        Scanner scan = new Scanner(new File("num1.txt"));
        String line = scan.nextLine();
        Boolean oops = true;
        for(int i = 0; i < line.length(); i++){
            String c = line.substring(i,i+1);
            if(c.equals("(")){
                tracker.push(new Node(1));
            }
            else if(c.equals("(")){
                if (tracker.peek() == null){
                    System.out.println("Too many closed");
                    i = line.length();
                    oops = true;
                }
                else{
                    tracker.pop();
                }
            }
        }
        
        if (tracker.peek() == null && oops == false){
            System.out.println("Perfect!");
        }
        else{
            System.out.println("Too many (");
        }
    }
}