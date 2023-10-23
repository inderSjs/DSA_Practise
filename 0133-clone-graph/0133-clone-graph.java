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
    public Node cloneGraph(Node node) {
        if( node == null ) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while( !q.isEmpty() ) {
            Node temp = q.poll();
            if( !map.containsKey(temp) ) {
                Node nd = new Node(temp.val);
                map.put(temp, nd);
            }
            for(Node ne: temp.neighbors) {
                if( !map.containsKey(ne) ) {
                    q.add(ne);
                }
            }
        }
        q.add(node);
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        while( !q.isEmpty() ) {
            Node temp = q.poll();
            for(Node ne: temp.neighbors) {
                map.get(temp).neighbors.add(map.get(ne));
                if( !set.contains(ne) ) {
                    q.add(ne);
                    set.add(ne);
                }
            }
        }
        return map.get(node);
    }
}