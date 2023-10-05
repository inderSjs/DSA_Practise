class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if( !map.containsKey(nums[i]) ) {
                map.put(nums[i], 0);
            }
            int x = map.get(nums[i]);
            map.put(nums[i], x+1);
        }
        int cmp = n/3;
        for(Map.Entry<Integer, Integer> set: map.entrySet() ) {
            int x = set.getKey();
            if( map.get(x) > cmp ) {
                result.add(x);
            }
        }
        return result;
    }
}