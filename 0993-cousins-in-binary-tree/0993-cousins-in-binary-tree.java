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
    HashMap<TreeNode, Integer> map;
    boolean bool;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.map = new HashMap<>();
        dfs(root, x, 0);
        bool = false;
        dfs(root, y, 0);
        if( map.size() < 2 ) {
            return false;
        }
        List<Integer> temp = new ArrayList<>();
        for(TreeNode node: map.keySet() ) {
            temp.add(map.get(node));
        }
        return temp.get(0) == temp.get(1);
    }
    
    private void dfs(TreeNode root, int value, int level) {
        //base case
        if( root == null ) {
            return;
        }
        
        if(root.left != null && root.left.val == value) {
            map.put(root, level+1);
            bool = true;
            return;
        }
        if(root.right != null && root.right.val == value) {
            map.put(root, level+1);
            bool = true;
            return;
        }
        if( !bool ) {
            dfs(root.left, value, level+1);
        }
        if( !bool ) {
            dfs(root.right, value, level+1);
        }
        
        // dfs(root.right, value, level+1);
       
    }
}