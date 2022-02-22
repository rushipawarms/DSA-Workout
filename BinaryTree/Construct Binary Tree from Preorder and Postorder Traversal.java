class Solution 
{
    
    public TreeNode build(int[] pre,int psi,int pei,int[] post,int posi,int poei)
    {
        
        if(psi>pei)
        {
            return null;
        }
        if(psi==pei)
        {
            return new TreeNode(pre[psi]);
        }
        TreeNode root=new TreeNode(post[poei]);
        int right_sub_root=post[poei-1];
        int j=psi+1;
        int count=0;
        
        while(right_sub_root!=pre[j])
        {
            j++;
            count++;
        }
        root.left=build(pre,psi+1,psi+count,post,posi,posi+count-1);
        root.right=build(pre,psi+count+1,pei,post,posi+count,poei-1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder)
    {
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
}
