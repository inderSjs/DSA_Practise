class Node {
    int key;
    int value;
    Node next;
    
    public Node ( int key, int value ) {
        this.key = key;
        this.value = value;
    }
}


class MyHashMap {
    private Node[] map;

    public MyHashMap() {
        map = new Node[1000];
    }
    
    private int hash( int key ) {
        return key % 1000;
    }
    
    public void put(int key, int value) {
        int hsh = hash(key);
        Node temp = map[hsh];
        Node node = new Node( key, value );
        if( temp == null ) {
            map[hsh] = node;
            node.next = null;
        } else {
            Node curr = map[hsh];
            Node t1 = map[hsh];
            while( curr != null ) {
                if( curr.key == key ) {
                    curr.value = value;
                    return;
                }
                t1 = curr;
                curr = curr.next;
            }
            t1.next = node;
        }
    }
    
    public int get(int key) {
        int hsh = hash(key);
        Node curr = map[hsh];
        while( curr != null ) {
            if( curr.key == key ) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node head = map[index];
        if(head == null) return;
        if(head.key == key) {
            map[index] = head.next;
            head.next = null;
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while(curr != null) {
            if(curr.key == key) {
                prev.next = curr.next;
                curr.next = null;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */