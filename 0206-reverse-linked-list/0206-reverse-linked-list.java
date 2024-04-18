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
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null ) {
            return head;
        }
        return helper(head, null);
    }
    
    private ListNode helper(ListNode curr, ListNode prev) {
        //base case
        if( curr == null) {
            return prev;
        }
        
        //logic
        ListNode temp = curr.next;
        curr.next = prev;
        return helper(temp, curr);
    }
}