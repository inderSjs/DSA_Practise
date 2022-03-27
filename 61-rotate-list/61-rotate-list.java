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
    public ListNode rotateRight(ListNode head, int k) {
        if( k == 0 || head == null) {
            return head;
        }
        if( head.next == null ) {
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
       // System.out.println(size);
        int index = size - k;
        if( k == size ) {
            index = 0;
        }
        if( k > size ) {
            int n = k % size;
            if( n == 0) {
                return head;
            }
            index = size - n;
        }
        if( index == 0) {
            return head;
        }
        ListNode dummy = null;
        temp = head;
        int i = 0;
        while( i != index) {
            dummy = temp;
            temp = temp.next;
            i++;
        }
        ListNode end = temp;
        while( end.next != null ) {
            end = end.next;
        }
        end.next = head;
        dummy.next = null;
        return temp;
        
    }
}