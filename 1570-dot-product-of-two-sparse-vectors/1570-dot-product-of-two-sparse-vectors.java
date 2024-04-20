class SparseVector {
    private List<int []> list;
    
    SparseVector(int[] nums) {
        this.list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if( nums[i] != 0 ) {
                list.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        int len = vec.list.size();
        for( int i = 0; i < len; i++ ) {
            int key = binarySearch(vec.list.get(i)[0], this.list);
            if( key != -1) {
                result = result + vec.list.get(i)[1]*this.list.get(key)[1];
            } 
        }
        return result;
    }
    
    private int binarySearch(int target, List<int []> li) {
        int low = 0;
        int high = li.size()-1;
        while( low <= high ) {
            int mid = low + (high-low)/2;
            if( li.get(mid)[0] == target) {
                return mid;
            } else if( li.get(mid)[0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);