// 1. You are given a string str.
// 2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
// Use sample input and output to take idea about subsequences.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        ArrayList<String> ans= gss(str);
        System.out.println(ans);
    }

    public static ArrayList<String> gss(String str) {
        
        if(str.length()==0)
        {
            ArrayList<String> n=new ArrayList<>();
            n.add("");
            return n;
        }
        
        ArrayList<String> sans=gss(str.substring(1));
        
        char first_char=str.charAt(0);
        
        ArrayList<String> ans=new ArrayList<>();
        
        // not include
        
        for(int i=0;i<sans.size();i++)
        {
            String s=sans.get(i);
            ans.add(s);
        }
        //include
        for(int i=0;i<sans.size();i++)
        {
             String s=sans.get(i);
             s=first_char+s;
            ans.add(s);
        }
        return ans;
        
    }

}

