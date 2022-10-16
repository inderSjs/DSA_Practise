class Solution {
    int[][] edges;
    int n;
    boolean[] checked;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        edges = new int[n][n];
        for(int i = 0; i < prerequisites.length; i++) {
            int fv = prerequisites[i][1];
            int sv = prerequisites[i][0];
            edges[fv][sv] = 1;
        }
        boolean[] isVisited = new boolean[n];
        checked = new boolean[n];
        for(int i = 0; i < n; i++) {
                if( isCyclic(i, isVisited)) {
                    return false;
                }
            
        }
        return true;
    }
    
    public boolean isCyclic(int vertex, boolean[] isVisited) {
        if( checked[vertex]) {
            return false;
        }
        if( isVisited[vertex] ) {
            return true;
        }
        isVisited[vertex] = true;
        boolean ret = false;
        for(int i = 0; i < n; i++) {
            if( edges[vertex][i] == 1 ) {
                ret = isCyclic(i, isVisited);
                if( ret ) {
                    break;
                }
            }
        }
        isVisited[vertex] = false;
        checked[vertex] = true;
        return ret;
    }
}