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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if( n == 0) {
            return null;
        }
        int rootVal = postorder[n-1];
        TreeNode root = new TreeNode(rootVal);
        int rootidx = -1;
        for(int i = 0; i < n; i++) {
            if( inorder[i] == rootVal) {
                rootidx = i;
                break;
            }
        }
        int[] inleft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inright = Arrays.copyOfRange(inorder, rootidx+1, n);
        int[] postleft = Arrays.copyOfRange(postorder, 0, inleft.length);
        int[] postright = Arrays.copyOfRange(postorder, postleft.length, n-1 );
        root.right = buildTree(inright, postright);
        root.left = buildTree(inleft, postleft);
        return root;
    }
}