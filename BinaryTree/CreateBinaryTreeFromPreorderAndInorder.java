class Solution {
    
    public TreeNode build(int[] pre,int psi,int pei,int[] in,int isi,int iei)
    {
        if(psi>pei)
        {
            return null;
        }
        if(psi==pei)
        {
           return new TreeNode(pre[psi]);
        }
        TreeNode root=new TreeNode(pre[psi]);
        
        int j=isi;
        int count=0;
        while(in[j]!=root.val)
        {
            j++;
            count++;
        }
        root.left=build(pre,psi+1,psi+count,in,isi,j-1);
        root.right=build(pre,psi+count+1,pei,in,j+1,iei);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
     return build(preorder,0,preorder.length-1,inorder,0,inorder.length);   
    }
}
