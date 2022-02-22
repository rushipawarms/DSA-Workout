class Solution {
    
    public TreeNode build(int[] post,int psi,int pei,int[] in,int isi,int iei)
    {
        if(isi>iei)
        {
            return null;
        }
        if(isi==iei)
        {
           return new TreeNode(in[isi]);
        }
        TreeNode root=new TreeNode(post[pei]);
        
        int j=isi;
        int count=0;
        while(in[j]!=root.val)
        {
            j++;
            count++;
        }
        root.left=build(post,psi,psi+count-1,in,isi,j-1);
        root.right=build(post,psi+count,pei-1,in,j+1,iei);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
     return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1);   
    }
}
