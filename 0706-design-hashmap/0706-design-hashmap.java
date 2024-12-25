class MyHashMap {
    private Node[] storage;
    
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public void add(Node n, int key, int value) {
            Node dummy = n;
            Node prev = dummy;
            while( dummy != null ) {
                if( dummy.key == key) {
                    dummy.value = value;
                    return;
                }
                prev = dummy;
                dummy = dummy.next;
            }
            prev.next = new Node(key, value);
        }
        
        public void remove(Node n, int key) {
            Node dummy = n;
            Node prev = dummy;
            while( dummy != null ) {
                if( dummy.key == key) {
                    break;
                }
                prev = dummy;
                dummy = dummy.next;
            }
            if( dummy != null && dummy.next != null ) {
                prev.next = dummy.next;
                dummy.next = null;
            } else {
                prev.next = null;
            }
            
        }
        
        public int get(Node n, int key) {
            Node temp = n;
            while( temp != null ) {
                if( temp.key == key) {
                    return temp.value;
                }
                temp = temp.next;
            }
            return -1;
        }
    }

    public MyHashMap() {
        this.storage = new Node[10000];
    }
    
    private int hash(int key) {
        return key%10000;
    }
    
    public void put(int key, int value) {
        int pIdx = hash(key);
        if( storage[pIdx] == null) {
            storage[pIdx] = new Node(-1,-1);
        }
        storage[pIdx].add(storage[pIdx], key, value);
    }
    
    public int get(int key) {
        int pIdx = hash(key);
        if( storage[pIdx] == null) {
            return -1;
        }
        return storage[pIdx].get(storage[pIdx], key);
    }
    
    public void remove(int key) {
        int pIdx = hash(key);
        if( storage[pIdx] == null) {
            return;
        }
        storage[pIdx].remove(storage[pIdx], key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */