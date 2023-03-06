class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for( int start = 0; start < n; start++) {
            for( int end = start+1; end <= n; end++) {
                int temp = sum[end]-sum[start];
                if( temp == k) {
                    result++;
                }
            }
        }
        return result;
    }
}