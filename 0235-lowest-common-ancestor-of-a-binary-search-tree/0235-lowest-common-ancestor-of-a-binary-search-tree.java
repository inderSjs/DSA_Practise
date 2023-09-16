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
        TreeNode p1 = null;
        TreeNode q1 = null;
        if( p.val < q.val ) {
            p1 = p;
            q1 = q;
        } else {
            p1 = q;
            q1 = p;
        }
        while( temp != null) {
            if( p1.val <= temp.val && q1.val >= temp.val) {
                return temp;
            }
            if( p1.val < temp.val && q1.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }
}