// Brute Force Solution

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        for(int i = 0; i < n; i++) {
            int left_max = 0;
            int right_max = 0;
            //iterate over left
            for(int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            //iterate over right
            for(int j = i; j < n; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            result = result + Math.min(left_max, right_max) - height[i];
        }
        return result;
    }
}