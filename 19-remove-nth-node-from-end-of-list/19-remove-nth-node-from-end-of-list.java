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
        ListNode l1 = head;
        while( l1 != null) {
            size++;
            l1 = l1.next;
        }
        if( size == 1) {
            return null;
        }
        int index = size - n;
        if(index == 0) {
            head = head.next;
            return head;
        }
        int i = 0;
        l1 = head;
        ListNode temp = head;
        while ( i != index ) {
            temp = l1;
            l1 = l1.next;
            i++;
        }
        temp.next = l1.next;
        l1.next = null;
        return head;
    }
}