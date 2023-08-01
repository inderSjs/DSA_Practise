class Solution {
    private int[][] memo;
    
    public int rob(int[] nums) {
        // int sum = 0;
        // for(int num: nums) {
        //     sum += num;
        // }
        this.memo = new int[nums.length][40000];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 40000; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount) {
        if( index >= nums.length ) {
            return amount;
        }
        if( memo[index][amount] != -1) {
            return memo[index][amount];
        }
        //case 1
        int case1 = helper(nums, index+1, amount);
        int case2 = helper(nums, index+2, amount+nums[index]);
        memo[index][amount] = Math.max(case1, case2);
        return memo[index][amount];
    }
}