/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    private List<Node> pathP;
    private List<Node> pathQ;
    
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = p;
        while( root.parent != null) {
            root = root.parent;
        }
        backtrack(root,p,q,new ArrayList<>());
        for(int i = 0; i < pathP.size(); i++) {
            if( pathP.get(i) != pathQ.get(i) ) {
                return pathP.get(i-1);
            }
        }
        return null;
    }
    
    public void backtrack(Node root, Node p, Node q, List<Node> path) {
        if( root == null ) {
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
        backtrack(root.left,p,q,path);
        backtrack(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}