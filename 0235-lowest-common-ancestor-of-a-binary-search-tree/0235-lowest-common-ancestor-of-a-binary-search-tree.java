/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( p.val < q.val) {
            return helper(root, p, q);
        } else {
            return helper(root, q, p);
        }
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if( p.val <= root.val && q.val >= root.val) {
            return root;
        }
        
        if( p.val < root.val && q.val < root.val) {
            return helper(root.left, p, q);
        } else {
            return helper(root.right, p , q);
        }
    }
}