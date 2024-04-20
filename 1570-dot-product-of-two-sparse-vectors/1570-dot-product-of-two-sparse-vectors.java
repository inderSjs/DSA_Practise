class SparseVector {
    private HashMap<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        this.map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if( nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for(Map.Entry<Integer, Integer> el: vec.map.entrySet() ) {
            int key = el.getKey();
            if( this.map.containsKey(key) ) {
                result = result + this.map.get(key)*el.getValue();
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);