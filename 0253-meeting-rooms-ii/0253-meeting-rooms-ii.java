class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if( a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
            
        });
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> a-b);
        pq.add(intervals[0][1]);
        for(int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if( start >= pq.peek() ) {
                pq.poll();
                pq.add(end);
            } else {
                pq.add(end);
            }
        }
        return pq.size();
    }
}