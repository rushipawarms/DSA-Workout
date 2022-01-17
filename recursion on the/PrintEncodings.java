// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
// Use the input-output below to get more understanding on what is required
// 123 -> abc, aw, lc
// 993 -> iic
// 013 -> Invalid input. A string starting with 0 will not be passed.
// 103 -> jc
// 303 -> No output possible. But such a string maybe passed. In this case print nothing.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        printEncodings(str,"");
        

    }

    public static void printEncodings(String str,String asf) {


        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }
        
        char ch=str.charAt(0);
        if(ch=='0')
        {
            return;
        }
        
        String to_add=(char)('a'+Integer.parseInt(ch+"")-1)+"";
        
        String ros=str.substring(1);
        printEncodings(ros,asf+to_add);
        
        
        if(str.length()>=2)
        {
            
            String f_two=str.substring(0,2);
            
            int id=Integer.parseInt(f_two);
            
            if(id>=1 && id<=26)
            {
                String to_add1=(char)('a'+id-1)+"";
                 String ros1=str.substring(2);
                printEncodings(ros1,asf+to_add1);
            }
        }
        
        
    }

}
