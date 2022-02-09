class Solution {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] != 0 ) {
                temp[j] = nums[i];
                j++;
            }
        }
        for(int k = 0; k < j; k++) {
            nums[k] = temp[k];
        }
        for(int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}