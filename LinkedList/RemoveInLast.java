public void removeLast(){
      if(size()==0)
      {
          System.out.println("List is empty");
          return;
      }
      else if(size()==1)
      {
          head=tail=null;
          size--;
          return;
      }
      Node itr=head;
      for(int i=0;i<size-2;i++)
      {
          itr=itr.next;
      }
      itr.next=null;
      tail=itr;
      size--;
    }
