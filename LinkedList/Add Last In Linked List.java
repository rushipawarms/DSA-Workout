// 1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of addLast function. This function is supposed to add an element to the end of LinkedList. You are required to update head, tail and size as required.
// 3. Input and Output is managed for you. Just update the code in addLast function.a

 void addLast(int val) {
    Node nn=new Node();
    nn.data=val;
   
    if(size==0)
    {
        head=tail=nn;
    }
    else
    {
        tail.next=nn;
        tail=nn;
    }
    size++;
  }
