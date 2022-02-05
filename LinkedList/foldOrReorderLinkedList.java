/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getmid(ListNode head)
    {
        ListNode sl=head;
        ListNode fst=head;
        while(fst.next!=null && fst.next.next!=null)
        {
            sl=sl.next;
            fst=fst.next.next;
        }
        return sl;
    }
    public ListNode reverse(ListNode head2)
    {
        ListNode pre=null;
        ListNode cur=head2;
        while(cur!=null)
        {
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        
        return pre;
    }
    public void merge(ListNode h1,ListNode h2)
    {
        ListNode c1=h1;
        ListNode c2=h2;
        while(c2!=null)
        {
            ListNode n1=c1.next;
            ListNode n2=c2.next;
            
            c1.next=c2;
            c2.next=n1;
            
            c1=n1;
            c2=n2;
        }
    }
    public void reorderList(ListNode head) {
        
        ListNode mid=getmid(head);
        
        ListNode next=mid.next;
        mid.next=null;
        
        ListNode head2=reverse(next);
        
        merge(head,head2);
    }
}
