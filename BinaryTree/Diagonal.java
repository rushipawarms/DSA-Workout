class Tree
{
    public void rec(Node node, ArrayList<ArrayList<Integer>> ans, int level)
    {
        if(node==null)
        {
            return;
        }
        if(ans.size()==level)
        {
            ans.add(new ArrayList<>());
        }
        
        ans.get(level).add(node.data);
        
        rec(node.left,ans,level+1);
        rec(node.right,ans,level);
    }
     public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
           rec(root,ans,0);
           ArrayList<Integer> res=new ArrayList<>();
           
           for(int i=0;i<ans.size();i++)
           {
               for(int e:ans.get(i))
               {
                   res.add(e);
               }
           }
           return res;
      }
}
