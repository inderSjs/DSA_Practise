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
        TreeNode temp = root;
        if( p.val > q.val ) {
            return lowestCommonAncestor(root, q, p);
        } 
        while( temp != null) {
            if( p.val <= temp.val && q.val >= temp.val) {
                return temp;
            }
            if( p.val < temp.val && q.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }
}