// 1. You are given a postfix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to prefix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> val=new Stack<>();
    Stack<String> is=new Stack<>();
    Stack<String> pr=new Stack<>();
    
    for(int i=0;i<exp.length();i++)
    {
        char ch=exp.charAt(i);
        if(ch=='+'|| ch=='-'|| ch=='*'|| ch=='/')
        {
            int val2=val.pop();
            int val1=val.pop();
            int finalVal=eval(val1,val2,ch);
            val.push(finalVal);
            
            String st2=is.pop();
            String st1=is.pop();
            String finalIs="("+st1+ch+st2+")";
            is.push(finalIs);
            
            String pst2=pr.pop();
            String pst1=pr.pop();
            String finalPr=ch+pst1+pst2;
            pr.push(finalPr);
        }
        else {
            val.push(ch-'0');
            is.push(ch+"");
            pr.push(ch+"");
        }
    }
    System.out.println(val.peek());
     System.out.println(is.peek());
      System.out.println(pr.peek());
    
 }
 public static int eval(int v1,int v2,char op)
 {
     if(op=='+')
     {
         return v1+v2;
     }
     else if(op=='-')
     {
         return v1-v2;
     }
     else if(op=='*')
     {
         return v1*v2;
     }
     else {
         return v1/v2;
     }
 }
}
