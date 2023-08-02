class Solution {
    private int[] memo;
    
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums) {
            arr[num] = arr[num] + num;
        }
        this.memo = new int[max+100];
        Arrays.fill(memo, -1);
        return helper(arr, 0, 0);
    }
    
    private int helper(int[] arr, int idx, int amount) {
        if( idx >= arr.length ) {
            return amount;
        }
        if( memo[idx] != -1) {
            return amount + memo[idx];
        }
        int case1 = helper(arr, idx+1, amount);
        int case2 = helper(arr, idx+2, amount + arr[idx]);
        int ans = Math.max(case1, case2);
        memo[idx] = ans;
        return ans;
    } 
}