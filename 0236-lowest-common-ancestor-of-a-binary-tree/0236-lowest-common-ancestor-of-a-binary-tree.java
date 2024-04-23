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
        Stack<TreeNode> st = new Stack<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root,null);
        st.push(root);
        while( !map.containsKey(p) || !map.containsKey(q) ) {
            TreeNode node = st.pop();
            if( node.left != null) {
                st.push(node.left);
                map.put(node.left, node);
            }
            if( node.right != null) {
                st.push(node.right);
                map.put(node.right, node);
            }
        }
        HashSet<TreeNode> set = new HashSet<>();
        while( p != null) {
            set.add(p);
            p = map.get(p);
        }
        while( !set.contains(q) ) {
            q = map.get(q);
        }
        return q;
    }
}