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
        List<List<Integer>> list = new ArrayList<>();
        if( root == null ) {
            return list;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(0);
        while( !q1.isEmpty() ) {
            TreeNode node = q1.poll();
            int col = q2.poll();
            if( !map.containsKey(col) ) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            min = Math.min(min, col);
            max = Math.max(max, col);
            if( node.left != null) {
                q1.add(node.left);
                q2.add(col-1);
            }
            if( node.right != null) {
                q1.add(node.right);
                q2.add(col+1);
            }
        }
        for(int i = min; i <= max; i++) {
            if( map.containsKey(i) ) {
                list.add(map.get(i));
            }
        }
        return list;
    }
}