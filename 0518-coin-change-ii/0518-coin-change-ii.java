class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length+1];
        for(int i = 0; i <= amount; i++ ) {
            for(int j = 0; j <= coins.length; j++) {
                dp[i][j] = -1;
            }
        } 
        return helper(coins, amount, coins.length-1);
    }
    
    public int helper(int[] coins, int amount, int index) {
        if( amount == 0 ) {
            return 1;
        }
        if( index < 0 || amount < 0 ) {
            return 0;
        }
        if( dp[amount][index] != -1 ) {
            return dp[amount][index];
        }
        int a = helper(coins, amount - coins[index], index);
        int b = helper(coins, amount, index -1);
        dp[amount][index] = (a+b);
        return dp[amount][index];
    }
}