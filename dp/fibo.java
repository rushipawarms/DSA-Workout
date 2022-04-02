import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
      Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int [] dp=new int[n+1];
    System.out.println(fib(n,dp));
 }

 public static int fib(int n,int[] dp)
 {
    if(n<=1) return n;

    if(dp[n]!=0) return dp[n];

    int ans=fib(n-1,dp)+fib(n-2,dp);

    dp[n]=ans;
    return ans;
 }
 

}
