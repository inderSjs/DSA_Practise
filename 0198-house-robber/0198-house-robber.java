class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max( curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}