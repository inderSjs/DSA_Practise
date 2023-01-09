class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        int a = Integer.MAX_VALUE-1;
        for(int i = 0; i <= len; i++) {
            for(int j = 0; j <= amount; j++) {
                if( i == 0) {
                    dp[i][j] = a;
                }
                if( j == 0 ) {
                    dp[i][j] = 0;
                }
            }
        }
        dp[0][0] = 0;
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= amount; j++) {
                if( coins[i-1] <= j ) {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if( dp[len][amount] == a ) {
            return -1;
        }
        return dp[len][amount];
    }
}