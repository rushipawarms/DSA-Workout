import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) 
    {
      if(  right.size()>0 &&right.peek()<val )
      {
        right.add(val);
      }
      else{
        left.add(val);
      }

      //balancing
      if(right.size()-left.size()==2)
      {
        left.add(right.remove());
      }
      else if(left.size()- right.size()==2)
      {
        right.add(left.remove());
      }

      
    }

    public int remove() {
      // write your code here
       if(left.size()==0 && right.size()==0)
      {
        System.out.println("Underflow");
        return -1;
      }
      else if(right.size()>left.size())
      {
        return right.remove();
      }
      else{
        return left.remove();
      }
    }

    public int peek() {
      // write your code here
      if(left.size()==0 && right.size()==0)
      {
        System.out.println("Underflow");
        return -1;
      }
      if(right.size()>left.size())
      {
        return right.peek();
      }
      else{
        return left.peek();
      }
    }

    public int size() {
      // write your code here

      return left.size()+right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
