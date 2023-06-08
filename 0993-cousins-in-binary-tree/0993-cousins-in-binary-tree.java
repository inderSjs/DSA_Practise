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
    int depthX;
    int depthY;
    TreeNode parentX;
    TreeNode parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return ( parentX != parentY && depthX == depthY);
    }
    
    private void dfs( TreeNode root, TreeNode parent, int depth, int x, int y) {
        //base case
        if( root == null ) {
            return;
        }
        
        if( root.val == x ) {
            depthX = depth;
            parentX = parent;
        }
        if( root.val == y ) {
            depthY = depth;
            parentY = parent;
        }
        dfs(root.left, root, depth+1, x, y);
        dfs(root.right, root, depth+1, x, y);
    }
}