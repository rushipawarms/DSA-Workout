// 1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<String> pre=new Stack<>();
    Stack<String> post=new Stack<>();
    Stack<Character> opr=new Stack<>();
    
    for(int i=0;i<exp.length();i++)
    {
        char ch=exp.charAt(i);
        if(ch=='(')
        {
            opr.push(ch);
            
        }
        else if( (ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')   )
        {
            pre.push(ch+"");
            post.push(ch+"");
        }
        else if(ch==')')
        {
            while(opr.peek()!='(')
            {
                String str2=pre.pop();
                String str1=pre.pop();
                char ch1=opr.pop();
                pre.push( ch1+str1+str2);
                
                String pstr2=post.pop();
                String pstr1=post.pop();
                post.push( pstr1+pstr2+ch1);
                
            }
            opr.pop();
        }
        else if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
        {
             while(opr.size()>0 && opr.peek()!='(' && prec(ch) <= prec(opr.peek()))
             {
                 String str2=pre.pop();
                String str1=pre.pop();
                char ch1=opr.pop();
                pre.push( ch1+str1+str2);
                
                String pstr2=post.pop();
                String pstr1=post.pop();
                post.push( pstr1+pstr2+ch1);
             }
             opr.push(ch);
        }
    }
    while(opr.size()>0 )
             {
                 String str2=pre.pop();
                String str1=pre.pop();
                char ch1=opr.pop();
                pre.push( ch1+str1+str2);
                
                String pstr2=post.pop();
                String pstr1=post.pop();
                post.push( pstr1+pstr2+ch1);
             }
   
   System.out.println(post.peek());
   System.out.println(pre.peek());
   
 }
 
  public static int prec(char opr )
    {
        if(opr=='+')
        {
            return 1;
        }
        else if(opr=='-')
        {
            return 1;
        }
        else if(opr=='*')
        {
            return 2;
        }
        else
        {
            return 2;
        }
    }
 
}
