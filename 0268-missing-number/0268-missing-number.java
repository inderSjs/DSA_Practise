class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums) {
            set.add(x);
        }
        for(int i = 0; i <= n; i++) {
            if( !set.contains(i)) {
                return i;
            }
        }
        return 1112;
    }
}