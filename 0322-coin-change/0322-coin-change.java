class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        this.memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        int result =  helper(coins, amount, coins.length-1);
        if( result == Integer.MAX_VALUE-1) {
            return -1;
        }
        return result;
    }
    
    private int helper(int[] coins, int amount, int idx) {
        //base case
        if( amount == 0 ) {
            return 0;
        }
        
        if( amount < 0 || idx < 0) {
            return Integer.MAX_VALUE-1;
        }
        if( memo[idx][amount] != -1) {
            return memo[idx][amount];
        }
        if( amount >= coins[idx] ) {
            memo[idx][amount] = Math.min( 1 + helper(coins, amount-coins[idx], idx), helper(coins, amount, idx-1));
            return memo[idx][amount];
        } else {
            memo[idx][amount] = helper(coins, amount, idx-1);
            return memo[idx][amount];
        }
    }
}