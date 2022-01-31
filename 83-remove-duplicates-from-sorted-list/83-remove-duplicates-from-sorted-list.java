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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;
        ListNode t1 = head;
        ListNode prev = null;
        HashSet<Integer> set = new HashSet<>();
        while( t1 != null) {
            if( set.contains(t1.val)) {
                prev.next = t1.next;
            } else {
                set.add(t1.val);
                prev = t1;
            }
            t1 = t1.next;
        }
        return root;
    }
}