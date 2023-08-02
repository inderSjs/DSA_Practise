class Solution {
    private int[][] memo;
    public int minCost(int[][] costs) {
        int n = costs.length;
        this.memo = new int[3*n][40*n];
        for(int i = 0; i < (3*n); i++) {
            for(int j = 0; j < (40*n); j++) {
                memo[i][j] = -1;
            }
        }
        int a = helper(costs, 0, 1, costs[0][0]);
        int b = helper(costs, 1, 1, costs[0][1]);
        int c = helper(costs, 2, 1, costs[0][2]);
        return Math.min(a , Math.min(b,c));
    }
    
    private int helper(int[][] costs, int i, int idx, int amount) {
        if( idx == costs.length) {
            return amount;
        }
        int i1 = idx*3 + i;
        if( memo[i1][amount] != -1 ) {
            return memo[i1][amount];
        }
        int x = (i+1)%3;
        int y = (i+2)%3;
        int case1 = helper(costs, x, idx+1, amount + costs[idx][x]);
        int case2 = helper(costs, y, idx+1, amount + costs[idx][y]);
        int t4 = Math.min(case1, case2);
        memo[i1][amount] = t4;
        return t4;
    }
}