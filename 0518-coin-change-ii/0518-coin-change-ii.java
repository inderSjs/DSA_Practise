class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(coins, coins.length-1, amount);
    }
    
    public int helper(int[] coins, int index, int amount) {
        if( amount == 0 ) {
            return 1;
        }
        if( index < 0 ) {
            return 0;
        }
        if( dp[index][amount] != -1 ) {
            return dp[index][amount];
        }
        if( coins[index] <= amount ) {
            return dp[index][amount] = helper(coins, index, amount - coins[index]) + helper(coins, index-1, amount);
        } else {
            return dp[index][amount] = helper(coins, index-1, amount);
        }
    }
}