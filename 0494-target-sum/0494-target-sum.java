class Solution {
    
    public int[][] memo;
    
    public int findTargetSumWays(int[] nums, int target) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++ ) {
            temp = temp + nums[i];
        }
        temp = (temp + target);
        if( temp % 2 != 0 ) {
            return 0;
        }
        temp = temp/2;
        if( temp < 0 ) {
            return 0;
        }
        //System.out.println(temp);
        memo = new int[nums.length][temp+1];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <= temp; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(nums, nums.length-1, temp);
        //return count;
    }
    
    public int helper(int[] nums, int index, int sum) {
        if( sum == 0 && index < 0) {
            //count = count + 1;
            return 1;
        }
        if( index < 0 ) {
            return 0;
        }
        if( memo[index][sum] != -1 ) {
            return memo[index][sum];
        }
        if( nums[index] <= sum ) {
            memo[index][sum] = helper(nums, index-1, sum - nums[index]) + helper(nums, index-1, sum);
            return memo[index][sum];
           
        } else {
            memo[index][sum] = helper(nums, index-1, sum);
            return memo[index][sum];
        }
    }
}