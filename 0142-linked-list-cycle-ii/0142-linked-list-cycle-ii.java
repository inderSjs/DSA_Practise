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
    public ListNode detectCycle(ListNode head) {
        if( head == null ) {
            return head;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        // ListNode prev = null;
        while( temp != null ) {
            if( set.contains(temp) ) {
                // System.out.println(prev.val);
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}