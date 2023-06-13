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
    int result;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }
    
    public int dfs(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        int extra = root.val -1 + dfs(root.left) + dfs(root.right);
        result += Math.abs(extra);
        return extra;
    }
}