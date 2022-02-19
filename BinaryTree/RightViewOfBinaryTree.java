class Solution{
    //Function to return list containing elements of right view of binary tree.
      public static void rec(Node root, int h,ArrayList<Integer> al)

    {
        if(root==null) return ;

        if(al.size()==h)
        {
            al.add(root.data);
        }
        rec(root.right,h+1,al);
        rec(root.left,h+1,al);
        
    }

    ArrayList<Integer> rightView(Node root)
    {
      ArrayList<Integer> al=new ArrayList<>();
      rec(root,0,al);

      return al;
    }
}
