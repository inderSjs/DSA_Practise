class Tuple {
    int a;
    int b;
    
    public Tuple(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Inefficient approach
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if( !map.containsKey(num)) {
                map.put(num,0);
            }
            int cnt = map.get(num);
            map.put(num, ++cnt);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>( new Comparator<Tuple>() {
            public int compare(Tuple x, Tuple y) {
                return x.b - y.b;
            }
        });
        for(Map.Entry<Integer, Integer> el: map.entrySet()) {
            pq.add(new Tuple(el.getKey(), el.getValue()));
            if( pq.size() > k ) {
                pq.poll();
            }
        }
        List<Integer> arr = new ArrayList<>();
        while( pq.size() != 0) {
            arr.add(pq.poll().a);
        }
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}