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
        HashSet<ListNode> set=new HashSet<>();
        
        ListNode ptr=head;
        
        while(ptr!=null){
            if(set.contains(ptr)){
                return true;
            }
            set.add(ptr);
            ptr=ptr.next;
        }
        return false;
    }
}