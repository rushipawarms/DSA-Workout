import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
static class pair{

    Node node;
    int state;

    public pair(Node node,int state){
        this.node=node;
        this.state=state;
    }
}
  
 public static void preAndPost(Node root)
 {
 
     String pre="";
     String post="";
    Stack<pair> st=new Stack<>();
    pair p=new pair(root,-1);
    st.push(p);

    while(st.size()>0)
    {
        pair t=st.peek();
        if(t.state==-1)
        {
            pre=pre+t.node.data+" ";
            t.state=t.state+1;
        }
        else if(t.state>=0 && t.node.children.size()>t.state)
        {
            pair np=new pair(t.node.children.get(t.state),-1);
            st.push(np);
            t.state++;
        }
        else
        {
            pair rm=st.pop();
            post=post+rm.node.data+" ";
            
        }

    }

System.out.println(pre);
System.out.println(post);
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

   

    Node root = construct(arr);
    preAndPost(root);
  }

}
