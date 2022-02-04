class Solution {
    int count;
    boolean[][] isVisited;
    
    public int numIslands(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        isVisited[i][j] = true;
        int[] a = new int[]{1,-1};
        int[] b = new int[]{-1,1};
        for(int c = 0; c < 2; c++) {
            if( (i + a[c]) >= 0 && (i + a[c]) < grid.length ) {
                int aa = i + a[c];
                if( grid[aa][j] == '1' && !isVisited[aa][j] ) {
                    dfs(grid, aa, j);
                }
            }
            if( (j + b[c]) >= 0 && (j + b[c]) < grid[0].length ) {
                int bb = j + b[c];
                if( grid[i][bb] == '1' && !isVisited[i][bb] ) {
                    dfs(grid, i, bb);
                }
            }
        }
    }
}