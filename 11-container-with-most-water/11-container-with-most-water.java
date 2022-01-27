class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int area = 0;
        int ht;
        int i = 0;
        int j = height.length - 1;
        while( i != j) {
            int width = j-i;
            if( height[i] > height[j] ) {
                ht = height[j];
                j--;
            } else {
                ht = height[i];
                i++;
            }
            area = ht*width;
            if( area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}