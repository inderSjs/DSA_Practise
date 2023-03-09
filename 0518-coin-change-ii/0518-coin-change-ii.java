class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(coins, coins.length-1, amount);
    }
    
    private int helper(int[] coins, int index, int amount) {
        if( amount == 0) {
            return 1;
        }
        if( index < 0) {
            return 0;
        }
        if( memo[index][amount] != -1 ) {
            return memo[index][amount];
        }
        if( amount >= coins[index]) {
            memo[index][amount] = helper(coins, index, amount-coins[index]) + helper(coins, index-1, amount);
        } else {
            memo[index][amount] = helper(coins, index-1, amount);
        }
        return memo[index][amount];
    }
}