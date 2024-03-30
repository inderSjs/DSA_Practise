class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        for(int num: nums) {
            pq.add(num);
            if( pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}