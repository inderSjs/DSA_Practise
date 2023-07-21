class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int dist = Math.abs(x-arr[i]);
            map.put(i, dist);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int distA = map.get(a);
            int distB = map.get(b);
            if( distA == distB ) {
                return b-a;
            }
            return distB-distA;
        });
        for(int i = 0; i < arr.length; i++) {
            pq.add(i);
            if( pq.size() > k ) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while( !pq.isEmpty() ) {
            result.add(arr[pq.poll()]);
        }
        Collections.sort(result);
        return result;
    }
}