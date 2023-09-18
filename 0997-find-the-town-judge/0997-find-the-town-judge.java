class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for(int[] e: trust) {
            int a = e[0];
            int b = e[1];
            map.get(a).add(b);
        }
        boolean flag = true;
        for(int i = 1; i <= n; i++) {
            if( map.get(i).size() == 0) {
                flag = true;
                for(int j = 1; j <= n; j++) {
                    if( i != j ) {
                        if( !map.get(j).contains(i) ) {
                            flag = false;
                        }
                    }
                }
                if( flag ) {
                    return i;
                }
            }
        }
        return -1;
    }
}