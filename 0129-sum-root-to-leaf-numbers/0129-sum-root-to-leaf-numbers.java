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
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> mst = new Stack<>();
        int curr = 0;
        int result = 0;
        while(root != null || !st.isEmpty() ) {
            while( root != null ) {
                curr = curr*10 + root.val;
                st.push(root);
                mst.push(curr);
                root = root.left;
            }
            root = st.pop();
            curr = mst.pop();
            if( root.left == null && root.right == null) {
                result = result + curr;
            }
            root = root.right;
        }
        return result;
    }
}