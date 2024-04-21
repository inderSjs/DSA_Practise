class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean[] isVisited;
    
    public int countComponents(int n, int[][] edges) {
        this.map = new HashMap<>();
        this.isVisited = new boolean[n];
        for(int[] edge: edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if( !map.containsKey(v1) ) {
                map.put(v1, new ArrayList<>());
            }
            if( !map.containsKey(v2) ) {
                map.put(v2, new ArrayList<>());
            }
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if( !isVisited[i] ) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int node) {
        isVisited[node] = true;
        List<Integer> list = map.get(node);
        if( list != null ) {
            for(int i = 0; i < list.size(); i++) {
                if( !isVisited[list.get(i)] ) {
                    dfs(list.get(i));
                }
            }
        }
    }
}