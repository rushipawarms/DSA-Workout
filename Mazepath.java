// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
// 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
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
        
        if(sc>dc || sr>dr)
        {
               ArrayList<String> temp=new ArrayList<>();
           
            return temp;
        }
        ArrayList<String> ans=new ArrayList<>();
        ArrayList<String> sans1=getMazePaths(sr,sc+1,dr,dc);
        for(int i=0;i<sans1.size();i++)
        {
            String st=sans1.get(i);
            String path="h"+st;
            ans.add(path);
        }
        
        ArrayList<String> sans2=getMazePaths(sr+1,sc,dr,dc);
          for(int i=0;i<sans2.size();i++)
        {
            String st=sans2.get(i);
            String path="v"+st;
            ans.add(path);   
        }
        return ans;
        
    }

}
