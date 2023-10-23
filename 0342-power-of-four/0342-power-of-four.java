class Solution {
    public boolean isPowerOfFour(int n) {
        int temp = n;
        if( n == -1 ) {
            return false;
        }
        if( n > 0 ) {
            return helper(n);
        } else {
            return false;
        }
    }
    
    private boolean helper(int n) {
        if( n == 1) return true;
        int temp = (int)Math.sqrt(n);
        int check = 1;
        for(int i = 1; i < temp; i++) {
            check = check*4;
            if( check == n ) {
                return true;
            }
        }
        return false;
    }
}