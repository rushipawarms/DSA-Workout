
//this is optimize solution.
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
public static int height(Node node)
{
  int h=-1;
  for(Node child:node.children)
  {
    int rec_h=height(child);
    h=Math.max(rec_h,h);
  }
  return h+1;
}

// public static int diameter(Node root)
// {
//     int mh=-1;
//     int smh=-1;
//     int di=-1;
//     for(Node child:root.children)
//     {
//       int h=height(child);
//       if(h>mh)
//       {
//         smh=mh;
//         mh=h;
//       }
//       else if(h>smh)
//       {
//         smh=h;
//       }
//     }

//     di=mh+smh+2;

//     for(Node child:root.children)
//     {
//       di=Math.max(di,diameter(child));
//     }

//     return di;
// }
static int Global_diameter;
public static int diameter1(Node root)
{
    int mh=-1;
    int smh=-1;
   
    for(Node child:root.children)
    {
      int h=diameter1(child);
      if(h>mh)
      {
        smh=mh;
        mh=h;
      }
      else if(h>smh)
      {
        smh=h;
      }
    }

    int di=mh+smh+2;
    Global_diameter=Math.max(di,Global_diameter);
   

    return mh+1;
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
    int d=diameter1(root);
    System.out.println(Global_diameter);
  }

}
