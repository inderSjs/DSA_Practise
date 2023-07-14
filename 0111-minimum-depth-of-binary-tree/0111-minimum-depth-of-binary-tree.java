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
    public int minDepth(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        if( root.left != null && root.right != null ) {
            return 1 + Math.min(helper(root.left), helper(root.right));
        } else if( root.left == null && root.right == null ) {
            return 1;
        } else if ( root.left == null) {
            return 1 + helper(root.right);
        }
        return 1 + helper(root.left);
    }
    
    private int helper(TreeNode root) {
        if( root.left == null && root.right == null ) {
            return 1;
        }
        int x  = Integer.MAX_VALUE;
        int y  = Integer.MAX_VALUE;
        if( root.left != null ) {
            x = 1 + helper(root.left);
        }
        if( root.right != null ) {
            y = 1 + helper(root.right);
        }
        return Math.min(x,y);
    }
    
}