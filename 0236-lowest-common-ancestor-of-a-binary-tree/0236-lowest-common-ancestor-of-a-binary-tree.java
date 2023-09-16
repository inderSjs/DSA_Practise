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
    private List<TreeNode> pathP;
    private List<TreeNode> pathQ;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root,p,q,new ArrayList<>());
        for(int i = 0; i < pathP.size(); i++) {
            if( pathP.get(i).val != pathQ.get(i).val) {
                return pathP.get(i-1);
            }
        }
        return null;
    }
    
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if( root == null) {
            return;
        }
        
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        path.remove(path.size()-1);
    }
}