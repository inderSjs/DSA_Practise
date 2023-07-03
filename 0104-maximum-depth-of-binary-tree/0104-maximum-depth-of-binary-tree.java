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
    int max;
    public int maxDepth(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        max = 0;
        helper(root, 1);
        return max;
    }
    
    private void helper(TreeNode root, int h) {
        if( root.left == null && root.right == null ) {
            max = Math.max(max, h);
            return;
        }
        if( root.left != null ) {
            helper(root.left, h+1);
        }
        if( root.right != null ) {
            helper(root.right, h+1);
        }
    }
}