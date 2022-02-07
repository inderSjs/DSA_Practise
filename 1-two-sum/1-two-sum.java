class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if( map.containsKey(complement) && i != map.get(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
            }
        }
        return result;
    }
}