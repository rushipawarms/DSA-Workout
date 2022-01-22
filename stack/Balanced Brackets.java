// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
       Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        System.out.print(BalB(str));

    }

    public static boolean BalB(String str)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                st.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']')
            {
                if(st.size()==0) return false;
                
                if(ch==')' && st.peek()!='(') return false;
                 if(ch=='}' && st.peek()!='{') return false;
                  if(ch==']' && st.peek()!='[') return false;
                  
                  st.pop();
            }
            
        }
        
        if(st.size()!=0) return false;
        return true;
        
    }
}
