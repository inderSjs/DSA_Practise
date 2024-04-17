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
    int index;
    boolean flag;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        index = 1;
        flag = true;
        result = -1;
        inOrder(root,k);
        return result;
    }
    
    public void inOrder(TreeNode root, int k) {
        if( flag ) {
            if( root == null ) {
                return;
            }
            inOrder(root.left,k);
            if( k == index) {
                result = root.val;
                flag = false;
            }
            index++;
            inOrder(root.right,k);
        }
    }
}