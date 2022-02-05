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
    public boolean hasCycle(ListNode head) {
        
        ListNode fast=head;
        ListNode sl=head;
        while(fast!=null && fast.next!=null)
        {
            sl=sl.next;
            fast=fast.next.next;
            
            if(sl==fast) return true;
        }
        return false;
    }
}
