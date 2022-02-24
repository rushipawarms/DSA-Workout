class BSTIterator {
        ArrayList<Integer> inorder;
    int i=-1;
    public void rec(TreeNode root,ArrayList<Integer> inorder)
    {
        if(root==null) return;
        rec(root.left,inorder);
        inorder.add(root.val);
        rec(root.right,inorder);
    }
    public BSTIterator(TreeNode root) {
        inorder=new ArrayList<>();
        rec(root,inorder);
        
    }
    
    public int next() {
        i++;
        return inorder.get(i);
    }
    
    public boolean hasNext() {
        return i+1<inorder.size();
        
    }
}
