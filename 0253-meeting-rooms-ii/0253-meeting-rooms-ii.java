class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                if( a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval: intervals) {
            if( !pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}