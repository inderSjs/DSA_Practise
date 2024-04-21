class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] isVisited = new boolean[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
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
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if( !isVisited[i] ) {
                q.add(i);
                while( !q.isEmpty() ) {
                    int node = q.poll();
                    isVisited[node] = true;
                    List<Integer> list = map.get(node);
                    if( list != null) {
                        for(int j = 0; j < list.size(); j++) {
                            int temp = list.get(j);
                            if( !isVisited[temp] ) {
                                q.add(temp);
                            }
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}