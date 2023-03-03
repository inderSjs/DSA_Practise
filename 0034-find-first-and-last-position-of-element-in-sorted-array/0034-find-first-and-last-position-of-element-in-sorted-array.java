class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int n = nums.length;
        if( n == 0 ) return result;
        if( n == 1 && nums[0] == target ) return new int[]{0,0};
        int low = 0;
        int high = low+1;
        while( low < n ) {
            if( nums[low] == target ) {
                result[0] = low;
                if( high < n && nums[high] == target) {
                    high++;
                } else {
                    result[1] = high-1;
                    return result;
                }
            } else {
                low++;
                high++;
            }
        }
        if( high == n && nums[n-1] == target) {
            result[1] = n-1;
        }
        return result;
    }
}