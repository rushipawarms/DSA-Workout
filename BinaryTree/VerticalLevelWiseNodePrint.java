import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void rec(Node node,int level,int[] minmax)
  {
    if(node==null)
    {
      return;
    }
    minmax[0]=Math.min(minmax[0],level);
    minmax[1]=Math.max(minmax[1],level);

    rec(node.left,level-1,minmax);
    rec(node.right,level+1,minmax);
  }
  public static ArrayList<ArrayList<Integer>> vertical(Node node) 
  {
     int[] minmax=new int[2];
     rec(node,0,minmax);

     int width=minmax[1]-minmax[0]+1;

     ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
     for(int i =0;i<width;i++)
     {
       ans.add(new ArrayList<>());
     }
     fill(ans,node,0,minmax[0]);
     return ans;
  }
public static void fill(ArrayList<ArrayList<Integer>> ans, Node node,int level, int min )
{
if(node==null)
{
  return;
}
int ind=level-min;
ans.get(ind).add(node.data);
fill(ans,node.left,level-1,min);
fill(ans,node.right,level+1,min);
}
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    
    Node root = construct(arr);
   ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
   ans=vertical(root);
   System.out.println(ans);
   
  }

}
