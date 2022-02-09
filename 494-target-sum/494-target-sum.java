class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int a = sum + target;
        if( a%2 != 0) {
            return 0;
        }
        a = a/2;
        if( a > 0) {
            dp = new int[len+1][a+1];
            return helper(nums, a); 
        } else {
            int x = a*(-1);
            dp = new int[len+1][x+1];
            return helper(nums, x);
        }
    }
    
    public int helper(int[] nums, int target) {
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if( nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}