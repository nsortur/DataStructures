import java.io.*;
import java.util.Scanner;
/**
* InfAdder.java
*
* Takes 2 files of integers(num1.txt and num2.txt), converts the integers from each
file
* into a linked list (makes a number), then adds the two numbers together. It uses a
modified digit class attached with this program.
*
* @author Neel Sortur
*/
public class InfAdder
{
//Head objects are defined for each file, as well as a result (sum) and number
//being carried over -see addSame()
Digit headOne;
Digit headTwo;
int carry;
Digit result;
/**
* The main method scans in the two files of 5 digits, and converts them into
arrays which will then be inserted into the linked list
* Sets the starting values of variables
lists)
* Runs each method in order (inserts into list, adds the lists, prints the
*/
public static void main(String [] args) {
try{
//Scanners
Scanner numOne;
numOne = new Scanner(new BufferedReader(new FileReader("num1.txt")));
Scanner numTwo;
numTwo = new Scanner(new BufferedReader(new FileReader("num2.txt")));
InfAdder list = new InfAdder();
list.headOne = null;
list.headTwo = null;
list.result = null;
list.carry = 0;
//Converts scanners into arrays
int[] arrayOne = new int[5];
for (int i = 0; i < arrayOne.length; i++){
arrayOne[i] = numOne.nextInt();;
}
int[] arrayTwo = new int[5];
for (int i = 0; i < arrayTwo.length; i++){
arrayTwo[i] = numTwo.nextInt();
}
//Create first list
for (int i = arrayOne.length - 1; i >= 0; --i){
list.insert(arrayOne[i], 1);
}
//Create second list
for (int i = arrayTwo.length - 1; i >= 0; --i){
list.insert(arrayTwo[i], 2);
}
list.addLists();
list.printlist(list.result);
}
catch(Exception e){
System.out.println("WAT");
System.exit(0);
}
}
/**
* Gets the size of each file
*
* @param head: The object in the file that points to the number; if it equals
null, then the counting of the size of the file is finished
*/
int getSize(Digit head){
int count = 0;
while (head != null)
{
count++;
head = head.next;
}
return count;
}
/**
* If the two lists are the same length, this adds them
* Like addition on paper, numbers have to be carried over when they exceed 10.
This adds the 'carry' int to each node so the addition is done properly
*
* @param first: The object made for the first list if the two are equal sizes
*
* @param second: The object made for the second list if the two are equal sizes
*/
void addSame(Digit first, Digit second){
if (first == null){
return;
}
addSame(first.next, second.next);
int sum = first.current + second.current + carry;
carry = sum / 10;
sum = sum % 10;
insert(sum, 3);
}
/**
* Inserts the value
*
* @param current: The main value that will be put into the linked list
*
* @param list: When list equals 1, that means the program is inserting the
values from the first file into the first list
* When list equals 2, that means the program is inserting the values from the
second file into the second list
* When the list equals 3, that means the program is adding a carried digit to
the front of the sum
*/
void insert(int current, int list){
Digit newDigit = new Digit(current);
if (list == 1)
{
newDigit.next = headOne;
headOne = newDigit;
}
else if (list == 2)
{
newDigit.next = headTwo;
headTwo = newDigit;
}
else if (list==3)
{
newDigit.next = result;
result = newDigit;
}
}
/**
* Prints the current value of head, which prints out the final sum
*
* @param head: The object in the file that points to the number; if it equals
null, then the counting of the size of the file is finished
*/
public void printlist(Digit head){
while (head != null)
{
System.out.print(head.current);
head = head.next;
}
}
//Current object pointer is defined
Digit curr;
/**
* Like addition on paper, numbers have to be carried over when they exceed 10.
This adds the 'carry' int to each node so the addition is done properly
* If there is an extra integer in carried, it adds to the front of the sum
*
* @param headOne: The head digit of the first list
*/
void carried(Digit headOne){
if (headOne != curr) {
carried(headOne.next);
int sum = carry + headOne.current;
carry = sum / 10;
sum %= 10;
insert(sum, 3);
}
}
/**
* This method adds the lists together. If the lists are the same size, it adds
them together using addSame()
* Takes into account if the lists are different sizes
*/
void addLists(){
int sizeOne = getSize(headOne);
int sizeTwo = getSize(headTwo);
//Add same size lists
if (sizeOne == sizeTwo) {
addSame(headOne, headTwo);
}
else{
if (sizeOne < sizeTwo) {
Digit temp = headOne;
headOne = headTwo;
headTwo = temp;
}
//sizeOne could be bigger than sizeTwo, so the pointer has to be
//switched- that's why there's absolute value
int diff = Math.abs(sizeOne - sizeTwo);
Digit temp = headOne;
while (diff-- >= 0){
curr = temp;
temp = temp.next;
}
addSame(curr, headTwo);
carried(headOne);
}
// If a number still needs to be carried, it adds to the front of the sum
if (carry > 0){
insert(carry, 3);
}
}
}