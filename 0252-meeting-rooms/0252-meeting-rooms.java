class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if( intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                if( a[0] == b[0] ) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if( intervals[i][0] < end ) {
                return false;
            }
            end = Math.max(end, intervals[i][1]);
        }
        return true;
    }
}