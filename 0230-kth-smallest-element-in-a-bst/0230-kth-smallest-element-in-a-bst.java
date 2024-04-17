/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int index = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while( curr != null || !st.isEmpty() ) {
            while( curr != null ) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            index++;
            if( index == k) {
                return curr.val;
            }
            // list.add(curr.val);
            curr = curr.right;
        }
        return -1;
    }
}