public void removeAt(int idx) {
        if(idx<0 || idx>=size)
      {
          System.out.println("Invalid arguments");
          return;
      }
      else if(idx==0)
      {
          removeFirst();
          return;
      }
      else if(idx==size-1)
      {
          removeLast();
          return;
      }
     
      Node itr=head;
      for(int i=0;i<idx-1;i++)
      {
          itr=itr.next;
      }
      itr.next=itr.next.next;
      size--;
    }
