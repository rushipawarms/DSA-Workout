//here we use recusion , inroder of BST is sorted always. So we we inorder approach here.
class Solution {
    TreeNode pre=null;
    boolean ans=true;
    public void traval(TreeNode node)
    {
        if(node==null) return ;
        
        traval(node.left);
        if(pre!=null)
        {
            if(pre.val>=node.val)
            {
                ans=false;
            }
        }
        pre=node;
        traval(node.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        
       
        traval(root);
        return ans;
    }
}
