class MyHashSet {
    private boolean[][] storage;
    private int bucket;
    private int bucketItem;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.storage = new boolean[bucket][];
    }
    
    private int hash1(int key) {
        return key%bucket;
    }
    
    private int hash2(int key) {
        return key/bucket;
    }
    
    public void add(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if( storage[pIdx] == null) {
            if( pIdx == 0 ) {
                storage[pIdx] = new boolean[bucketItem+1];
            } else {
                storage[pIdx] = new boolean[bucketItem];
            }
            
        }
        storage[pIdx][nIdx] = true;
    }
    
    public void remove(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if( storage[pIdx] == null) {
            return;
        }
        storage[pIdx][nIdx] = false;
    }
    
    public boolean contains(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if( storage[pIdx] == null) {
            return false;
        }
        return storage[pIdx][nIdx];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */