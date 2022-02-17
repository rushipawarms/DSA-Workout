public static Node add(Node node, int data) {

    if(node==null)
    {
      Node n=new Node(data,null,null);
      return n;
    }
    if(node.data>data)
    {
      node.left=add(node.left,data);
    }
    else{
      node.right=add(node.right,data);
    }

    return node;
  }
