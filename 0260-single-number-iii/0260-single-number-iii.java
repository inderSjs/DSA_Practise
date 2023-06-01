class Solution {
    public int[] singleNumber(int[] nums) {
        int mask1 = 0;
        for(int num: nums) {
            mask1 = mask1 ^ num;
        }
        int temp = mask1 & (-mask1);
        int x = 0;
        for(int i: nums) {
            if( (i & temp) != 0) {
                x = x ^ i;
            }
        }
        int y = x ^ mask1;
        return new int[]{x,y};
    }
}