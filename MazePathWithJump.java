// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        ArrayList<String> ans=getMazePaths(0,0,n-1,m-1);
        System.out.print(ans);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc)
        {
            ArrayList<String> temp=new ArrayList<>();
            temp.add("");
            return temp;
        }
      
        
       ArrayList<String> ans=new ArrayList<>();
       for(int h_jump=1; h_jump+sc<=dc;h_jump++)
       {
           ArrayList<String> sans=getMazePaths(sr,sc+h_jump,dr,dc);
           
           for(int j=0;j<sans.size();j++)
           {
               String s=sans.get(j);
               String t="h"+h_jump+s;
               ans.add(t);
           }
       }
       
        for(int v_jump=1; v_jump+sr<=dr;v_jump++)
       {
           ArrayList<String> sans=getMazePaths(sr+v_jump,sc,dr,dc);
           
           for(int j=0;j<sans.size();j++)
           {
               String s=sans.get(j);
               String t="v"+v_jump+s;
               ans.add(t);
           }
       }
        for(int d_jump=1; d_jump+sc<=dc && d_jump+sr<=dr ;d_jump++)
       {
           ArrayList<String> sans=getMazePaths(sr+d_jump,sc+d_jump,dr,dc);
           
           for(int j=0;j<sans.size();j++)
           {
               String s=sans.get(j);
               String t="d"+d_jump+s;
               ans.add(t);
           }
       }
       return ans;
       
    }

}
