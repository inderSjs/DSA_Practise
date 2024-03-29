/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if( root == null ) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while( !q.isEmpty() ) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                Node node = q.poll();
                if( k != size-1) {
                    // Node temp = q.poll();
                    node.next = q.peek();
                }
                // node.next = q.peek();
                if( node.left != null ) {
                    q.add(node.left);
                    q.add(node.right);
                }
                if( k == size-1) {
                    node.next = null;
                }
            }
        }
        return root;
    }
}