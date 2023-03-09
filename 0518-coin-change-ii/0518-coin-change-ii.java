// Time Complexity : O(n x amount)
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[] dp = new int[amount+1];
        for(int i = 0; i <= amount; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= amount; j++) {
                if( j >= coins[i-1] ) {
                    dp[j] = dp[j-coins[i-1]] + dp[j];
                }
            }
        }
        return dp[amount];
    }
}