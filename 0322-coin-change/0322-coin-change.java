class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        int temp = Integer.MAX_VALUE-1;
        int a =  helper(coins, coins.length-1, amount);
        if ( a == Integer.MAX_VALUE-1) {
            return -1;
        } else {
            return a;
        }
    }
    
    public int helper(int[] coins, int index, int amount) {
        if( amount == 0 ) {
            return 0;
        }
        if( index < 0 || amount < 0 ) {
            return Integer.MAX_VALUE-1;
        }
        if( dp[index][amount] != -1) {
            return dp[index][amount];
        }
        if( coins[index] <= amount){
            return dp[index][amount] = Math.min( 1 + helper(coins, index, amount - coins[index]), helper(coins, index-1, amount));
        } else {
            return dp[index][amount] = helper(coins, index-1, amount);
        }
        
        
        
    }
}