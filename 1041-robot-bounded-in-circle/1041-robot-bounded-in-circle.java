// Time Complexity: O(n)
// Space complexity: O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int x = 0;
        int y = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            char c = instructions.charAt(i);
            if( c == 'G') {
                x = x + dirs[idx][0];
                y = y + dirs[idx][1];
            } else if( c == 'L' ) {
                idx = (idx+3)%4;
            } else {
                idx = (idx+1)%4;
            }
        }
        return ( x== 0 && y == 0) || idx != 0;                            
    }
}