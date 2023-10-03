class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int[] map = new int[101];
        for(int x: nums) {
            // map[x]++;
            result = result + map[x];
            map[x]++;
        }
        return result;
    }
}