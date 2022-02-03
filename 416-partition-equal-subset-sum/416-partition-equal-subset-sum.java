class Solution {
    boolean[][] dp;
    //int[][] t;
    public boolean canPartition(int[] nums) {
        //recursive solution
        int sum = 0;
        int N = nums.length;
        for(int i = 0; i < N; i++) {
            sum = sum + nums[i];
        }
        if( sum % 2 != 0) {
            return false;
        }
        sum = sum/2;
        dp = new boolean[N+1][sum+1];
        //t = new int[N][sum+1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= sum; j++) {
                if( i == 0 ) {
                    dp[i][j] = false;
                }
                if( j == 0 ) {
                    dp[i][j] = true;
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= sum; j++) {
                if( nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
/*    
    public boolean helper(int[] arr, int target, int n) {
        if( target == 0 ) {
            return true;
        }
        if( n < 0 ) {
            return false;
        }
        if( t[n][target] != -100) {
            //t[n][target] = 1;
            return dp[n][target];
        }
        if( arr[n] <= target ) {
            t[n][target] = 1;
            dp[n][target] = helper(arr, target - arr[n], n-1) || helper(arr, target, n-1);
            return dp[n][target];
        } else {
            t[n][target] = 1;
            dp[n][target] = helper(arr,target, n-1);
            return dp[n][target];
        }
    } */
}