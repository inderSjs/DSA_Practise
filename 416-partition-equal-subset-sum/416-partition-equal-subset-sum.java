class Solution {
    boolean[][] t;
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if( sum % 2 != 0) {
            return false;
        }
        sum = sum/2;
        t = new boolean[nums.length+1][sum+1];
        for(int i = 0; i <= nums.length; i++) {
            for(int j = 0; j <= sum; j++) {
                if( i == 0 ) {
                    t[i][j] = false;
                }
                if( j == 0 ) {
                    t[i][j] = true;
                }
            }
        }
        t[0][0] = true;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= sum; j++) {
                if( nums[i-1] <= j ) {
                    t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[nums.length][sum];
    }
 /*   
    public boolean helper(int[] nums, int n, int target) {
        if( target == 0 ) {
            return true;
        }
        if( n < 0 || target < 0 ) {
            return false;
        }
        if( t[n][target] != -100) {
            if( t[n][target] == 1 ) {
                return true;
            } else {
                return false;
            }
        }
        boolean include = helper(nums, n-1, target - nums[n]);
        boolean exclude = helper(nums, n-1, target);
        boolean x = (include || exclude);
        if( x ) {
            t[n][target] = 1;
        } else {
            t[n][target] = 0;
        }
        return x;
    }  */
}