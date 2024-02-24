class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < length; i++){
            int complement = target - nums[i];
            if( map.containsKey(complement) && (map.get(complement) != i) ) {
                result[0] = i;
                result[1] = map.get(complement);
                break;
            }
        }
        return result;  
    }
}