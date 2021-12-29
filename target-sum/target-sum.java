class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, nums.length);
    }
    
    public int helper(int[] nums, int target, int n) {
        if( n == 0 && target == 0) {
            return 1;
        }
        if( n == 0 && target != 0) {
            return 0;
        }
        return helper(nums, target - nums[n-1], n-1) + helper(nums, target + nums[n-1], n-1);
        
    }
}