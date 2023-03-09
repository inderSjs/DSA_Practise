class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        int x = helper(coins, coins.length-1, amount);
        if( x == Integer.MAX_VALUE-1) {
            return -1;
        }
        return x;
    }
    
    public int helper(int[] coins, int index, int amount) {
        if( amount == 0 ) {
            return 0;
        }
        
        if( index < 0 || amount < 0) {
            return Integer.MAX_VALUE-1;
        }
        if( memo[index][amount] != -1 ) {
            return memo[index][amount];
        }
        if( coins[index] <= amount) {
            memo[index][amount] = Math.min( 1 + helper(coins, index, amount-coins[index]), helper(coins, index-1, amount));
            return memo[index][amount];
        } else {
            memo[index][amount] = helper(coins, index-1, amount);
            return memo[index][amount];
        }
    }
}