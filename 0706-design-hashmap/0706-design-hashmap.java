class MyHashMap {
    private int[][] storage;
    private int bucket;
    private int bucketItem;

    public MyHashMap() {
        this.storage = new int[1000][];
        this.bucket = 1000;
        this.bucketItem = 1000;
    }
    
    private int hash1(int key) {
        return key%1000;
    }
    
    private int hash2(int key) {
        return key/1000;
    }
    
    public void put(int key, int value) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if( storage[pIdx] == null) {
            storage[pIdx] = new int[bucketItem+1];
            Arrays.fill(storage[pIdx], -1);
        }
        storage[pIdx][nIdx] = value;
    }
    
    public int get(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if( storage[pIdx] == null) {
            return -1;
        }
        return storage[pIdx][nIdx];
    }
    
    public void remove(int key) {
        int pIdx = hash1(key);
        int nIdx = hash2(key);
        if( storage[pIdx] == null) {
            return;
        }
        storage[pIdx][nIdx] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */