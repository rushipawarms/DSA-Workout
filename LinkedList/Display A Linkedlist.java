// 1. You are given a partially written LinkedList class.
// 2. Here is a list of existing functions:
//    2.1 addLast - adds a new element with given value to the end of Linked List
// 3. You are required to complete the body of display function and size function
//    3.1. display - Should print the elements of linked list from front to end in a single line. Elements should be separated by space.
//    3.2. size - Should return the number of elements in the linked list.
// 4. Input and Output is managed for you.



        if(size==0)
        {
            return ;
        }
      Node ir=head;
      while(ir.next!=null)
      {
          System.out.print(ir.data+" ");
          ir=ir.next;
      }
      System.out.println(ir.data+" ");
    
