class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if( !map.containsKey(num) ) {
                map.put(num, 0);
            }
            int count = map.get(num);
            count++;
            map.put(num, count);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (int)(map.get(a) - map.get(b));
            }
        });
        for(Map.Entry<Integer, Integer> el: map.entrySet() ) {
            pq.add(el.getKey());
            if( pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while( !pq.isEmpty() ) {
            result.add(pq.poll());
        }
        int[] ans = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}