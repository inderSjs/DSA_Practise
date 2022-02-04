class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
        
        public void insert(Node node) {
                        // Node root = new Node();
                        // root.value = node.value;
                        // root.key = node.key;
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        
        public void removeNode(Node node) {
            Node t1 = node.prev;
            Node t2 = node.next;
            t1.next = t2;
            t2.prev = t1;
        }
        
        public void moveToHead(Node node) {
            removeNode(node);
            insert(node);
        }
        
        public Node removeTail() {
            Node del = tail.prev;
            removeNode(del);
            return del;
        }
    
    
    HashMap<Integer, Node> map;
    int size;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if( map.containsKey(key) ) {
            Node root = map.get(key);
            moveToHead(root);
            return root.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node root = map.get(key);
        if( root == null ) {
            Node temp = new Node();
            temp.key = key;
            temp.value = value;
            insert(temp);
            map.put(key, temp);
            size++;
            if( size > capacity ) {
                Node t3 = removeTail();
                map.remove(t3.key);
                size--;
            }
        } else {
            root.value = value;
            moveToHead(root);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */