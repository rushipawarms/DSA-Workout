/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
        {
            return null;
        }
        ListNode sl=head;
        ListNode fst=head;
        
        while(fst!=null && fst.next!=null)
        {
            sl=sl.next;
            fst=fst.next.next;
            
            if(sl==fst)
            {
                break;
            }
        }  
            if(sl!=fst)
            {
                return null;
            }
            
            sl=head;
            while(sl!=fst)
            {
                sl=sl.next;
                fst=fst.next;
            }
        
        return sl;
    }
}
