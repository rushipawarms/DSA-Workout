// 1. You are given a partially written LinkedList class.
// 2. Here is a list of existing functions:
//    2.1 addLast - adds a new element with given value to the end of Linked List
//    2.2. display - Prints the elements of linked list from front to end in a single line. All 
//      elements are separated by space
//      2.3. size - Returns the number of elements in the linked list.
// 3. You are required to complete the body of removeFirst function 
//      3.1. removeFirst - This function is required to remove the first element from 
//           Linked List. Also, if there is only one element, this should set head and tail to 
//           null. If there are no elements, this should print "List is empty".
// 4. Input and Output is managed for you.


 public void removeFirst(){
        if(size==0)
        {
            System.out.println("List is empty");
            return;
        }
        else if(size==1)
        {
            head=null;
            tail=null;
            
        }
        else
        {
      head=head.next;
      
        }
        size--;
    }
