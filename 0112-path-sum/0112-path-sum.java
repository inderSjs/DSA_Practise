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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if( root == null ) {
            return false;
        }
        return helper(root, 0, targetSum);
        
    }
    
    public boolean helper(TreeNode root, int sum ,int targetSum) {
        //base case
        int temp = sum + root.val;
        if( root.left == null && root.right == null ) {
            if( temp == targetSum ) {
                return true;
            }
            return false;
        }
        boolean x1 = false;
        boolean x2 = false;
        if( root.left != null ) {
            x1 = helper(root.left, temp, targetSum);
        }
        if( root.right != null ) {
            x2 = helper(root.right, temp, targetSum);
        }
        return x1 || x2;
    }
}