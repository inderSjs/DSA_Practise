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
    List<Integer> list;
    
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        for(int i = 1; i < list.size(); i++) {
            if( list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void traverse(TreeNode root) {
        if( root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}