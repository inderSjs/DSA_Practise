class Solution {
    //public int vertices;
    public int[][] graph;
    
    public int countComponents(int n, int[][] edges) {
        int numberOfConnectedComponents = 0;
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = 0;
            }
        }
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
                numberOfConnectedComponents++;
            }
        }
        return numberOfConnectedComponents;
    }
    
    public void dfs(int vertex, boolean[] isVisited) {
        isVisited[vertex] = true;
        for(int i = 0; i < graph.length; i++) {
            if( graph[vertex][i] == 1 && !isVisited[i]) {
                dfs(i, isVisited);
            }
        }
    }
}