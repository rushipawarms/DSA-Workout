// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
// 3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not tes


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        ArrayList<String> arr= getStairPaths(n,0);
        System.out.print(arr);
    }

    public static ArrayList<String> getStairPaths(int n,int idx) {
       
       if(idx==n)
       {
           ArrayList<String> temp=new ArrayList<>();
           temp.add("");
           return temp;
       }
       if(idx>n)
       {
            ArrayList<String> temp=new ArrayList<>();
          
           return temp;
       }
         ArrayList<String> ans=new ArrayList<>();
        ArrayList<String> sans1= getStairPaths(n,idx+1); 
        
        for(int i=0;i<sans1.size();i++)
        {
            String st=sans1.get(i);
            String path="1"+st;
            ans.add(path);
        }
        
         ArrayList<String> sans2=getStairPaths(n,idx+2);
         
          for(int i=0;i<sans2.size();i++)
        {
            String st=sans2.get(i);
            String path="2"+st;
            ans.add(path);
        }
        
         ArrayList<String> sans3=getStairPaths(n,idx+3);
          for(int i=0;i<sans3.size();i++)
        {
            String st=sans3.get(i);
            String path="3"+st;
            ans.add(path);
        }
        
        return ans;
    }

}
