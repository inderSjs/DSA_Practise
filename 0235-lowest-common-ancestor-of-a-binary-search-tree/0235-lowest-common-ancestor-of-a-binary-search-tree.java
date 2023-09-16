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
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        TreeNode temp = root;
        // l1.add(temp);
        while( temp != p) {
            l1.add(temp);
            if( p.val < temp.val ) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        l1.add(temp);
        temp = root;
        while( temp != q) {
            l2.add(temp);
            if( q.val < temp.val ) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        l2.add(temp);
        if( l1.size() > l2.size() ) {
            return helper(l1, l2);
        }
        return helper(l2, l1);
    }
    
    public TreeNode helper(List<TreeNode> l1, List<TreeNode> l2) {
        // //l1 is always bigger than l2
        // for(int i = 0; i < l1.size(); i++) {
        //     System.out.print(l1.get(i).val + " ");
        // }
        // System.out.println();
        // for(int i = 0; i < l2.size(); i++) {
        //     System.out.print(l2.get(i).val + " ");
        // }
        for(int i = 0; i < l2.size(); i++) {
            if( l1.get(i).val != l2.get(i).val) {
                return l1.get(i-1);
            }
        }
        return l2.get(l2.size()-1);
    }
}