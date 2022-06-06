/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        if(headA==headB) return headA;
        ListNode prev=headA;
        ListNode curr=headA;
        while(curr!=null) {
            prev=curr;
            curr=curr.next;
        }
        prev.next=headB;
        ListNode ret= detectCycle(headA);
        prev.next=null;
        return ret;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==null || head.next==null) return null;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        if(fast!=slow) return null;
        slow=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}