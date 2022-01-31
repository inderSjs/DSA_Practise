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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode t1 = null;
        int carry = 0;
        int res = 0;
        while( l1 != null || l2 != null){
            if ( l1 == null) {
                res = l2.val + carry;
            }
            else if ( l2 == null) {
                res = l1.val + carry;
            }
            else {
                res = l1.val + l2.val + carry;
            }
            if ( res > 9 ) {
                carry = 1;
            } else {
                carry = 0;
            }
            res = res % 10;
            result.val = res;
            result.next = new ListNode();
            t1 = result;
            result = result.next;
            if ( l1 != null) {
                l1 = l1.next;
            }
            if ( l2 != null) {
                l2 = l2.next;
            }
        }
        if ( carry > 0) {
            result.val = carry;
        }
        if ( t1.next.val == 0) {
            t1.next = null;
        }
        return temp;
    }
}