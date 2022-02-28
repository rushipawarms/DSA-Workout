import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n1=scn.nextInt();
    int[] a1=new int[n1];
    for(int i=0;i<n1;i++)
    {
        a1[i]=scn.nextInt();
    }
    int n2=scn.nextInt();
    int[] a2=new int[n2];
    for(int i=0;i<n2;i++)
    {
        a2[i]=scn.nextInt();
    }

    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int i=0;i<n1;i++)
    {
        if(mp.containsKey(a1[i]))
        {
            int pre=mp.get(a1[i]);
            int ne=pre+1;
            mp.put(a1[i],ne);
        }
        else
        {
            mp.put(a1[i],1);
        }
    }

    for(int i=0;i<n2;i++)
    {
        int key=a2[i];
        if(mp.containsKey(key))
        {
            System.out.println(key);
            mp.remove(key);

        }
    }

 }

}
