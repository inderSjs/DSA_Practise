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
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode root, int currSum) {
        //base case
        currSum = currSum*10 + root.val;
        if( root.left == null && root.right == null ) {
            sum = sum + currSum;
            return;
        }
        if(root.left != null ) {
            helper(root.left, currSum);
        }
        if( root.right != null ) {
            helper(root.right, currSum);
        }
    }
}