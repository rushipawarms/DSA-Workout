// 1. You are given an infix expression.
// 2. You are required to evaluate and print it's value.

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String exp = br.readLine();
    
    Stack<Integer> opd=new Stack<>();
    Stack<Character> opr=new Stack<>();
    
    for(int i=0;i<exp.length();i++)
    {
        char ch=exp.charAt(i);
        if(ch=='(')
        {
            opr.push(ch);
        }
        else if(Character.isDigit(ch))
        {
            opd.push(ch-'0');
        }
        else if(ch==')')
        {
            while(opr.peek()!='('  )
            {
                char optor=opr.pop();
                int v2=opd.pop();
                int v1=opd.pop();
                int val=operation(v1,v2,optor);
                opd.push(val);
            }
           
            opr.pop();
            
        }
        else if(ch=='+'|| ch=='-'|| ch=='*' ||ch=='/')
        {
            while(opr.size()>0 && opr.peek()!='(' && precedence(ch)<=precedence(opr.peek()))
            {
                 char optor=opr.pop();
                int v2=opd.pop();
                int v1=opd.pop();
                int val=operation(v1,v2,optor);
                opd.push(val);
            }
            opr.push(ch);
        }
    }
      while(opr.size()>0)
            {
                char optor=opr.pop();
                int v2=opd.pop();
                int v1=opd.pop();
                int val=operation(v1,v2,optor);
                opd.push(val);
            }
            
    System.out.println(opd.peek());
}
    public static int precedence(char opt)
    {
        if(opt=='+')
        {
            return 1; 
        }
        else if(opt=='-')
        {
            return 1; 
        }
        else if(opt=='*')
        {
            return 2;
        }
        else{
            return 2;
        }
        
    }
    
    public static int operation(int v1,int v2,char opt)
    {
          if(opt=='+')
        {
            return v1+v2; 
        }
        else if(opt=='-')
        {
            return v1-v2;
        }
        else if(opt=='*')
        {
            return v1*v2;
        }
        else{
            return v1/v2;
        }
    }
    
 
}
