class Solution {
    int[][] t;
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if( sum % 2 != 0) {
            return false;
        }
        sum = sum/2;
        t = new int[nums.length+1][sum+1];
        for(int i = 0; i <= nums.length; i++) {
            for(int j = 0; j <= sum; j++) {
                t[i][j] = -100;
            }
        }
        return helper(nums, nums.length - 1, sum);
    }
    
    public boolean helper(int[] nums, int n, int target) {
        if( target == 0 ) {
            return true;
        }
        if( n < 0 || target < 0 ) {
            return false;
        }
        if( t[n][target] != -100) {
            if( t[n][target] == 1 ) {
                return true;
            } else {
                return false;
            }
        }
        boolean include = helper(nums, n-1, target - nums[n]);
        boolean exclude = helper(nums, n-1, target);
        boolean x = (include || exclude);
        if( x ) {
            t[n][target] = 1;
        } else {
            t[n][target] = 0;
        }
        return x;
    }
}