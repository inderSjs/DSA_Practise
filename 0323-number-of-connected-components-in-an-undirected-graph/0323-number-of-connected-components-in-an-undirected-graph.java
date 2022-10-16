class Solution {
    int[][] graph;
    
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        graph = new int[n][n];
        for(int i = 0; i < edges.length; i++) {
            int fv = edges[i][0];
            int sv = edges[i][1];
            graph[fv][sv] = 1;
            graph[sv][fv] = 1;
        }
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if( !isVisited[i] ) {
                dfs(i, isVisited);
                result++;
            }
        }
        return result;
    }
    
    public void dfs(int vertex, boolean[] isVisited) {
        isVisited[vertex] = true;
        for(int i = 0; i < isVisited.length; i++) {
            if( graph[vertex][i] == 1 && !isVisited[i] ) {
                dfs(i, isVisited);
            }
        }
    }
}