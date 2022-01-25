// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the height of bars in a bar chart.
// 3. You are required to find and print the area of largest rectangle in the histogram.

// e.g.
// for the array [6 2 5 4 5 1 6] -> 12

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] lse=new int[n];
    Stack<Integer> st=new Stack<>();
    lse[0]=-1;
    st.push(0);
    for(int i=1;i<n;i++)
    {
        while(st.size()>0 && a[i]<=a[st.peek()])
        {
            st.pop();
        }
        if(st.size()==0)
        {
            lse[i]=-1;
        }
        else{
            lse[i]=st.peek();
        }
        st.push(i);
    }
   Stack<Integer> st1=new Stack<>();
    int[] rse=new int[n];
     rse[n-1]=n;
     st1.push(n-1);
    for(int j=n-2;j>=0;j--)
    {
        while(st1.size()>0 && a[j]<=a[st1.peek()])
        {
            st1.pop();
        }
        if(st1.size()==0)
        {
        rse[j]=n;
        }
        else{
            rse[j]=st1.peek();
        }
        st1.push(j);
    }
    
    int max=0;
    for(int i=0;i<n;i++)
    {
        int width=rse[i]-lse[i]-1;
        int area=a[i]*width;
        if(area>max)
        {
            max=area;
        }
    }
   
        System.out.println(max);
    
    
    }
}
