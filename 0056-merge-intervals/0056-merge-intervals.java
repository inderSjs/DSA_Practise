class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                if( a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        int[] curr = new int[2];
        curr[0] = intervals[0][0];
        curr[1] = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if( intervals[i][0] <= curr[1] ) {
                if( intervals[i][1] >= curr[1] ) {
                    curr[1] = intervals[i][1];
                } 
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(curr[0]);
                list.add(curr[1]);
                result.add(list);
                curr[0] = intervals[i][0];
                curr[1] = intervals[i][1];
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(curr[0]);
        list.add(curr[1]);
        result.add(list);
        int[][] ans = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }
}