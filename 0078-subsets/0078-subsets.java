class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> list) {
        //base case
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        //dont include
        helper(nums, index+1, list);
        list.add(nums[index]);
        helper(nums, index+1, list);
        list.remove(list.size()-1);
    }
}