import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int[] a=new int[n];
    for(int i=0;i<n;i++)
    {
        a[i]=scn.nextInt();
    }
    HashSet<Integer> set=new HashSet<>();

    for(int i=0;i<n;i++)
    {
        set.add(a[i]);
    }
 int sp=-1;
 int max=0;
    for(int i=0;i<n;i++)
    {
        int key=a[i];
        if(set.contains(key-1)==false)
        {
            int len=1;
            while(set.contains(key+len))
            {
                len++;
            }
            if(len>max)
            {
                max=len;
                sp=key;
            }
        }

    }

    for(int i=0;i<max;i++)
    {
        System.out.println(sp+i);
    }
 }

}
