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
        ListNode newHead = head.next;
        ListNode temp = newHead.next;
        head.next = null;
        while( temp != null ) {
            newHead.next = head;
            head = newHead;
            newHead = temp;
            temp = temp.next;
        }
        newHead.next = head;
        // ListNode tt = newHead;
        // while(tt != null ) {
        //     System.out.print(tt.val + "->");
        //     tt = tt.next;
        // }
        return newHead;
    }
}