class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        } );
        for(int i = 0; i < nums.length; i++) {
            if( pq.size() == k) {
                if(pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            } else {
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }
}