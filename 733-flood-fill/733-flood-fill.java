class Solution {
    boolean[][] isVisited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old = image[sr][sc];
        image[sr][sc] = newColor;
        isVisited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, newColor, old);
        return image;
    }
    
    public void helper(int[][] image, int i, int j, int newColor, int oldColor) {
        isVisited[i][j] = true;
        int[] aa = new int[]{-1, 1};
        for(int k = 0; k < 2; k++) {
            int t1 = i + aa[k];
            if( t1 >= 0 && t1 < image.length && !isVisited[t1][j] && image[t1][j] == oldColor ) {
                image[t1][j] = newColor;
                helper(image, t1, j, newColor, oldColor);
            }
            int t2 = j + aa[k];
            if( t2 >= 0 && t2 < image[0].length && !isVisited[i][t2] && image[i][t2] == oldColor ) {
                image[i][t2] = newColor;
                helper(image, i, t2, newColor, oldColor);
            }
            
        }
    }
}