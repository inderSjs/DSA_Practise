class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int t = (target+sum);
        if( t%2 != 0) {
            return 0;
        }
        t = t/2;
        return helper(nums, t, nums.length-1);
    }
    
    public int helper(int[] nums, int target, int n) {
        if( n == -1 ) {
            if( target == 0 ) {
                count++;
                return count;
            } else {
                return count;
            }
        }
        if( nums[n] <= target ) {
            count = helper(nums, target - nums[n], n-1);
            count = helper(nums, target, n-1);
        } else {
            count = helper(nums, target, n-1);
        }
        return count;
    }
}