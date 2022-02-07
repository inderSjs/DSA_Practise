class Solution {
    boolean[][] isVisited;
    int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        isVisited = new boolean[m+1][n+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( !isVisited[i][j] && grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        isVisited[i][j] = true;
        int[] temp = new int[]{-1,1};
        for(int k = 0; k < 2; k++) {
            int x = i + temp[k];
            if( x >= 0 && x < grid.length && !isVisited[x][j] && grid[x][j] == '1') {
                dfs(grid,x,j);
            }
            int y = j + temp[k];
            if( y >= 0 && y < grid[0].length && !isVisited[i][y] && grid[i][y] == '1') {
                dfs(grid,i,y);
            }
        }
    }
}