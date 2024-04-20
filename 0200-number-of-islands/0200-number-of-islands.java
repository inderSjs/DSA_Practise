class Solution {
    int m;
    int n;
    boolean[][] isVisited;
    int[][] dirs;
    
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.isVisited = new boolean[m][n];
        this.dirs = new int[][]{{0,1},{1,0},{0,-1}, {-1,0}};
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == '1' && !isVisited[i][j] ) {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        isVisited[x][y] = true;
        for(int[] dir: dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if( i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1' && !isVisited[i][j] ) {
                dfs(grid, i, j);
            }
        }
    }
}