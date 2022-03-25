class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for(int i = 1; i < len; i++ ) {
            int key = nums[i];
            int j = i-1;
            while( j >= 0 && key < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
        return nums;
    }
}