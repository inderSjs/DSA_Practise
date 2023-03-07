class Solution {
    public int subarraySum(int[] nums, int k) {
        //map to store prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0,1); //Case where we do not remove anything
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if( map.containsKey(sum-k) ) {
                count = count + map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}