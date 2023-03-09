class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int a = Integer.MAX_VALUE-1;
        for(int i = 0; i <= coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if( j == 0) {
                    dp[i][j] = 0;
                }
                if( i == 0 ) {
                    dp[i][j] = a;
                }
            }
        }
        dp[0][0] = 0;
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if( j >= coins[i-1]) {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if( dp[coins.length][amount] >= a) {
            return -1;
        } else {
            return dp[coins.length][amount];
        }
    }
}