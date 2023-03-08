class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        if( n == 1) {
            return maxLen;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int rSum = 0;
        for(int i = 0; i < n; i++) {
            if( nums[i] == 0) {
                rSum--;
            } else {
                rSum++;
            }
            if( !map.containsKey(rSum) ) {
                map.put(rSum, i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(rSum));
            }
        }
        return maxLen;
    }
}