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
    ArrayList<Integer> list;
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<Integer>();
        helper(root);
        for(int i = 0; i < list.size()-1; i++) {
            if( list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    
    public void helper( TreeNode node ) {
        if( node == null ) {
            return;
        }
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }
}