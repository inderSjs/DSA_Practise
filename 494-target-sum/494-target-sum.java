class Solution {
    int count;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int t = (target+sum);
        if( t%2 != 0) {
            return 0;
        }
        t = t/2;
        if( t < 0 ) {
            int temp = (-1)*t;
            dp = new int[nums.length+1][temp+1];
            for(int i = 0; i <= nums.length; i++) {
                for(int j = 0; j <= temp; j++) {
                    dp[i][j] = -100;
                }
            }
            return helper(nums, temp, nums.length-1);
        } else {
            dp = new int[nums.length+1][t+1];
            for(int i = 0; i <= nums.length; i++) {
                for(int j = 0; j <= t; j++) {
                    dp[i][j] = -100;
                }
            }
            return helper(nums, t, nums.length-1);
        }
        //dp = new int[nums.length+1][t+1];
        /*for(int i = 0; i <= nums.length; i++) {
            for(int j = 0; j <= t; j++) {
                dp[i][j] = -100;
            }
        } */
        
        //return dp[nums.length][t];
    }
    
    public int helper(int[] nums, int target, int n) {
        if( n == -1 ) {
            if( target == 0 ) {
                return 1;
            } else {
                return 0;
            }
        }
        if( dp[n][target] != -100 ) {
            return dp[n][target];
        }
        if( nums[n] <= target ) {
            dp[n][target] = helper(nums, target - nums[n], n-1) + helper(nums, target, n-1);
        } else {
            dp[n][target] = helper(nums, target, n-1);
        }
        return dp[n][target];
    }
}