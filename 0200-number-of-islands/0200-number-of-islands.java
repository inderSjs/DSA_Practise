class Solution {
    boolean[][] isVisited;
    int m;
    int n;
    
    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( !isVisited[i][j] && grid[i][j] == '1') {
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        isVisited[i][j] = true;
        int[] x = new int[]{0,1,0,-1};
        int[] y = new int[]{1,0,-1,0};
        for(int k = 0; k < 4; k++) {
            int ni = i + x[k];
            int nj = j + y[k];
            if( ni >= 0 && nj >= 0 && ni < m && nj < n && !isVisited[ni][nj] && grid[ni][nj] == '1') {
                dfs(grid, ni, nj);
            }
        }
        
    }
}