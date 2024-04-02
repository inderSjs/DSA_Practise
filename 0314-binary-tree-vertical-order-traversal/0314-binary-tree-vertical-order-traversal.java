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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        int minValue = 0;
        int maxValue = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        q.add(root);
        col.add(0);
        while( !q.isEmpty() ) {
            TreeNode node = q.remove();
            int idx = col.remove();
            if( !map.containsKey(idx) ) {
                map.put(idx, new ArrayList<>());
            }
            map.get(idx).add(node.val);
            if( node.left != null) {
                q.add(node.left);
                int left = idx -1;
                minValue = Math.min(minValue, left);
                col.add(left);
            }
            if( node.right != null) {
                q.add(node.right);
                int right = idx + 1;
                maxValue = Math.max(maxValue, right);
                col.add(right);
            }
        }
        for(int i = minValue; i <= maxValue; i++) {
            if( map.containsKey(i) ) {
                List<Integer> li = map.get(i);
                result.add(li);
            }
        }
        return result;
    }
}