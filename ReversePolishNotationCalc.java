import java.io.*;
import java.util.Scanner;
/**
* An ATTEMPT at a Reverse Polish Notation Calculator, stack class takes params
*
* @author Neel Sortur
*/
public class ReversePolishNotation {
  public static void main(String[] args) throws Exception{
    Scanner scann = new Scanner(new BufferedReader(new
    FileReader("polish.txt")));
    Stack<String> file = new Stack<String>();
    Stack<Integer> resultant = new Stack<Integer>();
    while (scann.hasNext()) {
      file.push(scann.next());
    }
    double first;
    double second;
    String token;
    while (file.peek() != null) {
      token = file.pop();
      if (token == "+" || token == "-" || token == "*" || token =="/") {
        first = Double.parseDouble(file.pop());
        second = Double.parseDouble(file.pop());
        if (token == "+") {
          double result = first + second;
          file.push(Double.toString(result));
        } else if (token == "-") {
           double result = first - second;
           file.push(Double.toString(result));
        } else if (token == "/") {
           double result = first / second;
           file.push(Double.toString(result));
        }
        } else if (token == "*") {
            double result = first * second;
            file.push(Double.toString(result));
        }
          else {
            file.push(token);
        }
      }
    System.out.println(file.pop());
  }
}
