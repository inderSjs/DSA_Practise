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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if( head.next == null ){
            return null;
        }
        ListNode temp = head;
        int length = 0;
        while( temp != null ) {
            temp = temp.next;
            length++;
        }
        int k = length-n+1;
        length = 1;
        temp = head;
        ListNode prev = null;
        while( length != k) {
            prev = temp;
            temp = temp.next;
            length++;
        }
        if( prev == null ) {
            return head.next;
        }
        prev.next = prev.next.next;
        temp.next = null;
        return head;
    }
}