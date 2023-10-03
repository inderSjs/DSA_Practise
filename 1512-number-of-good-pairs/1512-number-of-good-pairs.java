class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int size = nums.length;
        for(int i = 0; i < size-1; i++) {
            for(int j = i+1; j < size; j++) {
                if( nums[i] == nums[j] ) {
                    result++;
                }
            }
        }
        return result;
    }
}