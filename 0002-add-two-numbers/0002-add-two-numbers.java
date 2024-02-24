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
        ListNode prev = null;
        int carry = 0;
        while( l1 != null && l2 != null ) {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            temp.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            temp.next = new ListNode();
            prev = temp;
            temp = temp.next;
        }
        while( l1 != null ) {
            int ad = l1.val + carry;
            carry = ad/10;
            temp.val = ad % 10;
            l1 = l1.next;
            temp.next = new ListNode();
            prev = temp;
            temp = temp.next;
        }
        while( l2 != null ) {
            int add = l2.val + carry;
            carry = add/10;
            temp.val = add % 10;
            l2 = l2.next;
            temp.next = new ListNode();
            prev = temp;
            temp = temp.next;
        }
        if( carry > 0 ) {
            temp.val = carry;
        } else {
            prev.next = null;
        }
        return result;
    }
}