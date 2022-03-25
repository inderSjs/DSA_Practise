class Pair<U, V> {
    public U first;
    public V second;
    
    public Pair( U first, V second ) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(int key) {
        for(Pair<Integer, Integer> pair : this.bucket) {
            if( pair.first.equals(key) ) {
                return pair.second;
            }
        }
        return -1;
    }
    
    public void update( int key, int value) {
        boolean bool = false;
        for(Pair<Integer, Integer> pair : this.bucket) {
            if( pair.first.equals(key)) {
                pair.second = value;
                bool = true;
            }
        }
        if ( !bool ) {
            Pair<Integer, Integer> pa = new Pair<Integer, Integer>( key, value);
            this.bucket.add(pa);
        }
    }
    
    public void remove(int key) {
        for(Pair<Integer, Integer> pair: this.bucket) {
            if( pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}


class MyHashMap {
    private int keySpace;
    private List<Bucket> map;

    public MyHashMap() {
        this.keySpace = 2069;
        this.map = new ArrayList<Bucket>();
        for(int i = 0; i < this.keySpace; i++) {
            this.map.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int index = key % this.keySpace;
        this.map.get(index).update(key, value);
    }
    
    public int get(int key) {
        int index = key % this.keySpace;
        return this.map.get(index).get(key);
    }
    
    public void remove(int key) {
        int index = key % this.keySpace;
        this.map.get(index).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */