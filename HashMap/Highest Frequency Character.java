import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String str=scn.next();

       HashMap<Character,Integer> mp=new HashMap<>();

       for(int i=0;i<str.length();i++)
       {
           char ch=str.charAt(i);
           if(mp.containsKey(ch))
           {
               int of=mp.get(ch);
               int nf=of+1;
               mp.put(ch,nf);
           }
           else{
               mp.put(ch,1);
           }
          
       }
       char ans='#';
       int max=0;
       for(int i=0;i<str.length();i++)
       {
           char ch=str.charAt(i);
           int fre=mp.get(ch);
           if(fre>max)
           {
               max=fre;
               ans=ch;
           }
       }
       System.out.println(ans) ;
       
    }

}
