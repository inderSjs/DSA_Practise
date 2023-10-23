/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> map; 
    
    public Node cloneGraph(Node node) {
        if( node == null ) {
            return null;
        }
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    
    public void dfs(Node node) {
        if( map.containsKey(node) ) {
            return;
        }
        Node nd = new Node(node.val);
        map.put(node, nd);
        for(Node v: node.neighbors) {
            dfs(v);
            nd.neighbors.add(map.get(v));
        }
    }
}