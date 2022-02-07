class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;
    
    class Node {
        int value;
        int key;
        Node prev;
        Node next;
    }
    
    public void addNode(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    
    public void evictNode(Node node) {
        //always remove from the end
        Node temp1 = node.prev;
        Node temp2 = node.next;
        temp1.next = temp2;
        temp2.prev = temp1;
    }
    
    public void moveToHead(Node node) {
        evictNode(node);
        addNode(node);
    }
    
    public Node removeTail() {
        Node temp = tail.prev;
        evictNode(temp);
        return temp;
        //temp.next = tail;
        //tail.prev = temp;
    }

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
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node root = map.get(key);
        if( root == null ) {
            Node temp = new Node();
            temp.key = key;
            temp.value = value;
            addNode(temp);
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