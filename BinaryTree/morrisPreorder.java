class Solution {
    public TreeNode rightMost(TreeNode node, TreeNode curr)
    {
        while(node.right!=null && node.right!=curr )
        {
            node=node.right;
        }
        return node;
    }
    public List<Integer> preorderTraversal(TreeNode root) 
    {
    
        TreeNode curr=root;
        ArrayList<Integer> ans=new ArrayList<>();
        while(curr!=null)
        {
            TreeNode left=curr.left;
            if(left==null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else
            {
                TreeNode rm=rightMost(left,curr);
                if(rm.right==null)
                {
                    rm.right=curr;
                     ans.add(curr.val);
                    curr=left;
                }
                else{
                    rm.left=null;
                   
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
