class Solution {
    
    public int count;
    
    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++ ) {
            temp = temp + nums[i];
        }
        temp = (temp + target);
        if( temp % 2 != 0 ) {
            return 0;
        }
        temp = temp/2;
        //System.out.println(temp);
        return helper(nums, nums.length-1, temp);
        //return count;
    }
    
    public int helper(int[] nums, int index, int sum) {
        if( sum == 0 && index < 0) {
            count = count + 1;
            return 1;
        }
        if( index < 0 ) {
            return 0;
        }
        if( nums[index] <= sum ) {
            return helper(nums, index-1, sum - nums[index]) + helper(nums, index-1, sum);
           
        } else {
           return helper(nums, index-1, sum);
        }
    }
}