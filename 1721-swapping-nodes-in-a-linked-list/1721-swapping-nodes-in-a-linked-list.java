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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int start=0;
        int end=0;
        ListNode ptr=head;
        for(int i=1;i<k;i++){
            ptr=ptr.next;
        }
        ListNode trav=head;
        ListNode temp=ptr;
        while(temp.next!=null){
            temp=temp.next;
            trav=trav.next;
        }
        int faval=trav.val;
        trav.val=ptr.val;
        ptr.val=faval;
        //System.out.println(ptr.val+" "+trav.val);
        return head;
    }
}