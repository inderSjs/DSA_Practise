class Solution {
    private boolean[][] isVisited;
    private int m;
    private int n;
    private int[][] dirs;
    
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.isVisited = new boolean[m][n];
        this.dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == '1'  && !isVisited[i][j] ) {
                    dfs(grid, i ,j);
                    result++;
                }
            }
        }
        return result;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        isVisited[i][j] = true;
        for(int[] dir: dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if( nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1' && !isVisited[nr][nc]) {
                dfs(grid, nr, nc);
            }
        }
    }
}