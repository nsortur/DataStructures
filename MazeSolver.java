import java.util.Scanner;
import java.util.Stack;
import java.io.*;
public class MazeSolver{
    
    public void solveMaze(String[][] field)throws Exception{
        String [][] maze = null;
        int rows = 0;
        int columns = 0;
        getLength(rows, columns);
        field = new String[rows][columns];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                maze[i][j] = field[i][j];
            }
        }
        Stack path = new Stack();
        
        
    }
    public void Main(String[]args)throws Exception{
        
        
    }
    public void getLength(int rows, int columns) throws Exception{
        Scanner scan = new Scanner(new File("maze.txt"));
        while(scan.hasNextLine() == false){
            if(scan.hasNextLine()){
                rows++;
            }
        }
        
      
        String line = scan.nextLine();
        for(int i = 0; i < line.length(); i++){
            columns++;
        }
        
        /**
        String line = scan.nextLine();
        if (scan.hasNextLine()){
            for(int i = 0; i < line.length(); i++){
                String token = line.substring(i,i+1);
                //Insert function here that uses the substring
                readMaze(token);
            }
            getLine();
        }
        else{
            System.out.println("no maze here");
        }
        */
    }
}