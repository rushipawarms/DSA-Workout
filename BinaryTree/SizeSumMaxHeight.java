  public static int size(Node node) {

    if(node==null)
    {
      return 0;
    }

    int ans=0;


  ans=ans+size(node.left);
  ans=ans+size(node.right);

    return ans+1;
  }

  public static int sum(Node node) {
    if(node==null)
    {
      return 0;
    }

    int sum=0;

    sum=sum+sum(node.left);
   sum=sum+sum(node.right);

   return sum+node.data;

  }

  public static int max(Node node) {

    if(node==null)
    {
      return Integer.MIN_VALUE;
    }

    int max=Integer.MIN_VALUE;

    int lm=max(node.left);
    int rm=max(node.right);

    max=Math.max(lm,rm);
    max=Math.max(max,node.data);

    return max;
    
  }

  public static int height(Node node) {
    
    if(node==null)
    {
      return -1;
    }


   int lh=height(node.left);
   int rh=height(node.right);

 int myH=Math.max(lh,rh);

 return myH+1;
   
  }
