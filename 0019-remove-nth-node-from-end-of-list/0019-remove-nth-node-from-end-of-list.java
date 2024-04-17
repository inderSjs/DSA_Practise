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
        int size = 0;
        ListNode temp = head;
        while( temp != null ) {
            size++;
            temp = temp.next;
        }
        int index = size - n + 1;
        temp = head;
        ListNode prev = null;
        size = 1;
        while( size != index ) {
            prev = temp;
            temp = temp.next;
            size++;
        }
        if( prev == null ) {
            return temp.next;
        }
        prev.next = temp.next;
        return head;
    }
}