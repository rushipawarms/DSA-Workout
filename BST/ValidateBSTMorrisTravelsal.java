class Solution {
    public TreeNode rightMost(TreeNode node, TreeNode curr)
    {
        while(node.right!=null && node.right!=curr )
        {
            node=node.right;
        }
        return node;
    }
    public boolean isValidBST (TreeNode root)  
    {

        TreeNode curr=root;
        TreeNode pre=null;
        ArrayList<Integer> ans=new ArrayList<>();
        while(curr!=null)
        {
            TreeNode left=curr.left;
            if(left==null)
            {
               // ans.add(curr.val);
                if(pre!=null && pre.val>=curr.val)
                {
                    return false;
                }
                pre=curr;
                curr=curr.right;
            }
            else
            {
                TreeNode rm=rightMost(left,curr);
                if(rm.right==null)
                {
                    rm.right=curr;
                    curr=left;
                }
                else{
                    rm.right=null;

                    // ans.add(curr.val);
                     if(pre!=null && pre.val>=curr.val)
                {
                    return false;
                }
                pre=curr;
                    curr=curr.right;
                }
            }
        }
        return true;
    }
}
