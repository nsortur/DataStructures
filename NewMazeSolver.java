import java.util.*;
import java.io.*;

/**
 * New mazesolver program, solves a maze with the following symbols
 * @: Start
 * $: End
 * #: Wall
 * .: Path
 * 
 * @author Neel Sortur
 * @version 2.0
 */
public class NewMazeSolver
{
    //Stacks and expandable arrays
    public static Stack x = new Stack();
    public static Stack y = new Stack();
    public static ArrayList<Integer> length = new ArrayList();
    public static ArrayList<Integer> width = new ArrayList();
    
    //variables
    public static String[][]arr;
    public static int checker = 0; 
    public static int column = 0;
    public static int row = 0;
    /**
     * Main method puts the file into an array from which it finds the start symbol
     */
    public static void Main(String[]args) throws Exception{
        Scanner scan = new Scanner(new File("maze.txt"));
        String store = "";
        //Finds the dimensions of the array
        while (scan.hasNextLine()) {
            store = scan.nextLine();
            row++;
        }
        column = store.length();
        scan.close();
        
        //Restarts scanner to reset the rows and columns
        arr = new String [row] [column];
        scan = new Scanner(new File("maze.txt"));
        String temporary = "";

        //Puts the maze file into an array
        while (scan.hasNext()) {
            for (int a = 0; a < row; a++){
                if(scan.hasNextLine()) {
                    temporary = scan.nextLine();
                }

                for (int b = 0; b < column; b++){
                    arr [a] [b] = (temporary.substring(b, b+1));
                }
            }
        }
        
        // Finds the start symbol (@)
        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++){
                if( (arr [r] [c]).equals("@")){
                    System.out.println("Start is in row " + r + " " +  "and column " + c);
                    pushArr(r,c);
                }
            }
        }
    }
    
    /**
     * pushArr() pushes the coordinates of the array into a 'y' and a 'x' stack, and prints those coordinates
     * 
     * @param y1: the y coordinate of the token being checked in the array
     * @param x1: the x coordinate of the token being checked in the array
     */
    public static void pushArr(int y1, int x1){
        y.push(y1);
        x.push(x1);
        System.out.println("(" + y1 + "," + x1 + ")");
        if((arr[y.peek()][x.peek()]).equals("$")){
            System.out.println("The end is in (" + y1 + "," + x1 + ") and you have reached the end");
        }
        else{
            //Puts a wall where the solver has already been so it doesn't go back to that spot
            arr[y1][x1] = "#";
            checkDir(y1,x1);
        }
    }
    
    /**
     * checkDir() finds the coordinates of the array when the token being checked is
     * moved either up, down, left, or right
     * 
     * @param y1: the y coordinate of the token being checked in the array
     * @param x1: the x coordinate of the token being checked in the array
     */
    public static void checkDir(int y1, int x1){
        
        String temp = " ";
        
        //Checks up
        if(y1 > 0 && y1 <= row) {
            temp = arr [(y1-1)] [x1];
        }
        
        if(temp.equals((".")) || temp.equals ("$")) {
            pushArr((y1-1),x1);  
            checker = 1;
        }

        //Checks down
        if(y1 <= row) {
            temp  = arr [(y1+1)] [x1];
        }

        if(temp.equals((".")) || temp.equals ("$")) {
            pushArr((y1+1),x1);  
            checker = 2;
        }

        //Checks left
        if (x1 > 0){
            temp  = arr [y1] [(x1-1)];
        }

        if(temp.equals((".")) || temp.equals ("$")) {
            pushArr(y1,(x1-1));  
            checker = 3;
        }

        //Checks right
        if (x1 <= column){
            temp = arr [y1] [(x1+1)];
        }    
        
        if(temp.equals((".")) || temp.equals ("$")) {
            pushArr(y1,(x1+1));  
            checker = 4;
        }
        else{
            //If it gets stuck on a wall, go backwards
            length.remove(0);
            width.remove(0);

            if (checker == 1 ) {
                arr [y1+1] [x1] = ("."); 
                checkDir(y1+1,x1);
            }
            if (checker == 2 ) {
                arr [y1-1] [x1] = ("."); 
                checkDir(y1-1,x1);
            }
            if (checker == 3 ) {
                arr [y1] [x1+1] = ("."); 
                checkDir(y1,x1+1);
            }
            if (checker == 4 ) {
                arr [y1] [x1-1] = ("."); 
                checkDir(y1,x1-1);
            }
        }
        
    }
    
}

