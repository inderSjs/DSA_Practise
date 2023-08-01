class Solution {
    // private int result;
    private int memo[][];
    public int change(int amount, int[] coins) {
        this.memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(coins, amount, 0);
        // return result;
    }
    
    private int helper(int[] coins, int amount, int index) {
        if( amount < 0 || index >= coins.length) {
            return 0;
        }
        if( amount == 0) {
            return 1;
        }
        if( memo[index][amount] != -1) {
            return memo[index][amount];
        }
        memo[index][amount] = helper(coins, amount, index+1) + helper(coins, amount-coins[index], index);
        return memo[index][amount];
    }
}