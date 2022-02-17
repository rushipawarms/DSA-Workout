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
  public static class pair{
    boolean isBst;
    int max;
    int min;
    int size;
    Node node_mix_bst;
    public pair(boolean isBst,int max,int min,int size,Node node_mix_bst)
    {
      this.isBst=isBst;
      this.max=max;
      this.min=min;
      this.size=size;
      this.node_mix_bst=node_mix_bst;
    }
  }
  public static pair lBST(Node root)
{

if(root==null)
{
  pair bp=new pair(true,Integer.MIN_VALUE,Integer.MAX_VALUE,0,null);
  return bp;
}
pair lp=lBST(root.left);
pair rp=lBST(root.right);

if(lp.isBst==true && rp.isBst && lp.max<root.data && root.data<rp.min)
{
  int max=Math.max(rp.max,root.data);
int min=Math.min(lp.min,root.data);

pair mypair=new pair(true,max,min,lp.size+rp.size+1,root);
return mypair;
}

 else{
   pair ne=new pair(false,0,0,0,null);
  if(lp.size>rp.size)
  {
    ne.size=lp.size;
    ne.node_mix_bst=lp.node_mix_bst;
  }
  else{
     ne.size=rp.size;
    ne.node_mix_bst=rp.node_mix_bst;
  }
  return ne;
 }
  
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
    pair ans=lBST(root);
   System.out.println(ans.node_mix_bst.data+"@"+ans.size);
    
  }

}
