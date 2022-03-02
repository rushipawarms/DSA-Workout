import java.io.*;
import java.util.*;

public class Main {
   public static class pair implements Comparable <pair> {
      int li;
      int data;
      int idx;

      public pair(int li,int idx,int data)
      {
         this.li=li;
         this.idx=idx;
         this.data=data;
      }
      //this code is not explain please do not panic
      public int compareTo (pair other)
      {
         return this.data-other.data;
      }
   }

   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<pair> pq=new PriorityQueue<>();
      for(int i=0;i<lists.size();i++)
      {
         pq.add(new pair(i,0,lists.get(i).get(0)));
      }

      while(pq.size()>0)
      {
         pair t=pq.remove();

         rv.add(t.data);

         int li=t.li;
         int idx=t.idx;
         if(idx+1<lists.get(li).size())
         {
            pq.add(new pair(li,idx+1,lists.get(li).get(idx+1)));
         }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
