class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if( !left.containsKey(x) ) {
                left.put(x, i);
            }
            right.put(x, i);
            if( count.containsKey(x) ) {
                int counter = count.get(x);
                count.put(x, counter+1);
            } else {
                count.put(x, 1);
            }
        }
        int degree = Collections.max(count.values());
        int result = nums.length;
        for(int x: count.keySet() ) {
            if( count.get(x) == degree) {
                result = Math.min( result, right.get(x) - left.get(x) + 1);
            }
        }
        return result;
    }
}