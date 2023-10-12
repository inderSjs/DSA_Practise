class Solution {
    HashMap<Integer, Integer> memo;
    public int jump(int[] nums) {
        if( nums.length < 2) {
            return 0;
        }
        this.memo = new HashMap<>();
        return dfs(nums, 0);
    }
    
    public int dfs(int[] nums, int idx) {
        if( idx >= nums.length-1) {
            return 0;
        }
        int min = Integer.MAX_VALUE-9;
        for(int i = 1; i <= nums[idx]; i++) {
            int j = i + idx;
            if( !memo.containsKey(j) ) {
                int temp = dfs(nums, j) + 1;
                memo.put(j, temp);
            }
            min = Math.min(min, memo.get(j));
        }
        memo.put(idx, min);
        return min;
    }
}