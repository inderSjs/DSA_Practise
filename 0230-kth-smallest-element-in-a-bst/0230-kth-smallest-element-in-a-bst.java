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
    int index;
    boolean flag;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
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
            list.add(root.val);
            if( k == index) {
                result = root.val;
                flag = false;
            }
            index++;
            inOrder(root.right,k);
        }
    }
}