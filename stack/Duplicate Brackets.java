// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.'
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        
        
        System.out.print(DubBr(str));

    }
    
    public static boolean DubBr(String exp)
    {
        Stack<Character> stk = new Stack<>(); 
        
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(ch==')')
            {
                if(stk.peek()=='(')
                {
                    return true;
                }
                
                while(stk.peek()!='(')
                {
                    stk.pop();
                }
                //pop opening bracket
                stk.pop();
            }
            else
            {
                stk.push(ch);
            }
        }
        return false;
    }

}
