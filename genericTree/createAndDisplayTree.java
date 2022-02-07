import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {

    System.out.print(node.data+"->");

    for(int i=0;i<node.children.size();i++)
    {
      System.out.print(node.children.get(i).data+" ");
    }
    System.out.println(".");

    for(int j=0;j<node.children.size();j++)
    {
      display(node.children.get(j));
    }
    
  }

  public static Node construct(int[] arr) {
    Node root=new Node();
    root.data=arr[0];

    Stack<Node> st=new Stack<>();
    st.push(root);
    for(int i=1;i<arr.length;i++)
    {
      if(arr[i]==-1)
      {
        st.pop();
      }
      else{
        Node ad=new Node();
        ad.data=arr[i];

        
       Node top=st.peek();

       top.children.add(ad);

       st.push(ad);

      }
    }
   return root;
  }

  // public static int size(Node node){
  //   // write your code here
  // }

  public static void main(String[] args) throws Exception {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // int n = Integer.parseInt(br.readLine());
    // int[] arr = new int[n];
    // String[] values = br.readLine().split(" ");
    // for (int i = 0; i < n; i++) {
    //   arr[i] = Integer.parseInt(values[i]);
    // }
int[] arr={10,50,60,-1,-1,20,70,-1,80,120,-1,-1,90,130,-1,-1,-1,30,-1,40,100,-1,110,-1,-1,-1};
    Node root = construct(arr);
    // int sz = size(root);
    // System.out.println(sz);
    display(root);
  }

}
