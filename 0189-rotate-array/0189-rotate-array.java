class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int index = k % n;
        int[] result = new int[n];
        int j = 0;
        for(int i = n-index; i < n; i++) {
            result[j] = nums[i];
            j++;
        }
        for(int i = 0; i < (n-index); i++) {
            result[j] = nums[i];
            j++;
        }
        for(int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}