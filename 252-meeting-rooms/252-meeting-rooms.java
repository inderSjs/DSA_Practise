class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length-1; i++) {
            int j = i+1;
            if( intervals[i][1] > intervals[j][0]) {
                return false;
            }
        }
        return true;
    }
}