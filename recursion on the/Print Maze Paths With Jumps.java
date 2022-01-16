// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
         Scanner scn=new Scanner(System.in);
	        int n=scn.nextInt();
	        int m=scn.nextInt();
	        printMazePaths(0,0,n-1,m-1,"");

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        
        if(sr==dr && sc==dc)
        {
            System.out.println(psf);
            return;
        }
        if(sr>dr || sc>dc)
        {
            return ;
        }
        
        for(int i=1;i+sc<=dc;i++)
        {
            printMazePaths(sr,sc+i,dr,dc,psf+"h"+i);
        }
        
        for(int i=1;i+sr<=dr;i++)
        {
            printMazePaths(sr+i,sc,dr,dc,psf+"v"+i);
        }
        
        for(int i=1;i+sc<=dc && i+sc<=dc;i++)
        {
            printMazePaths(sr+i,sc+i,dr,dc,psf+"d"+i);
        }
    }

}
