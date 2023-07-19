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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(ListNode ls: lists) {
            while( ls != null ) {
                int x = ls.val;
                list.add(x);
                ls = ls.next;
            }
        }
        if( list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        ListNode prev = new ListNode();
        ListNode head = prev;
        for(int i = 0; i < list.size(); i++) {
            ListNode t = new ListNode(list.get(i));
            prev.next = t;
            prev = t;
        }
        return head.next;
    }
}