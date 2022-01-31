// 1. You are given a number n, representing the number of time-intervals.
// 2. In the next n lines, you are given a pair of space separated numbers.
// 3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
// 4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

// E.g. Let us say there are 6 meetings
// 1 8
// 5 12
// 14 19
// 22 28
// 25 27
// 27 30

// Then the output of merged meetings will belongs
// 1 12
// 14 19
// 22 30

// Note -> The given input maynot be sorted by start-time.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        //sort two D array first 
        
        Arrays.sort(arr,(int[] a, int[] b)->{return a[0] - b[0];});
        
        Stack<int []> interval=new Stack<>();
        interval.push(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            int st=arr[i][0];
            int et=arr[i][1];
            if(interval.peek()[1]>=st)
            {
                int [] last_I=interval.pop();
                int [] merge=new int[2];
                
                merge[0]=last_I[0];
                merge[1]=Math.max(et,last_I[1]);
                interval.push(merge);
            }
            else
            {
                interval.push(arr[i]);
            }
        }
        
        Stack<int[]> temp=new Stack<>();
        while(interval.size()>0)
        {
            temp.push(interval.pop());
        }
        
        while(temp.size()>0)
        {
            int [] in=temp.pop();
            System.out.println(in[0]+" "+in[1]);
        }
        
    }

}
