class Solution {
    public int[][] merge(int[][] intervals) {
        /*int n = intervals.length;
        for(int i = 0; i < (n-1); i++) {
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if( intervals[j][0] < intervals[minIndex][0]) {
                    minIndex = j;
                }
            }
            int temp = intervals[minIndex][0];
            intervals[minIndex][0] = intervals[i][0];
            intervals[i][0] = temp;
        } */
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] interval: intervals) {
            if( list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}