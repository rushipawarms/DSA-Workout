class Solution
{
    static class pair{
        Node node;
        int level;
        public pair(Node node,int level)
        {
            this.node=node;
            this.level=level;
        }
        
    }
    static void travel(Node node, int level,int [] minmax)
    {
        if(node==null)
    {
      return;
    }
    minmax[0]=Math.min(minmax[0],level);
    minmax[1]=Math.max(minmax[1],level);

    travel(node.left,level-1,minmax);
    travel(node.right,level+1,minmax);
    }
    
    static ArrayList<Integer> bottomView(Node root)
    {
        int[] minmax=new int[2];
        travel(root,0,minmax);
        int w=minmax[1]-minmax[0]+1;
        
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<w;i++)
        {
            ans.add(-1);
        }
        LinkedList<pair> que=new LinkedList<>();
        que.add(new pair(root,0));
        while(que.size()>0)
        {
            pair t=que.removeFirst();
            Node n=t.node;
            int l=t.level;
            
            int idx=l-minmax[0];
           // if(ans.get(idx)==-1)
            //{
                ans.set(idx,n.data);
           // }
            if(n.left!=null)
            {
                que.addLast(new pair(n.left,l-1));
            }
             if(n.right!=null)
            {
                que.addLast(new pair(n.right,l+1));
            }
        }
        
    
        return ans;
    }
}
