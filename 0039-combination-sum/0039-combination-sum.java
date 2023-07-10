class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int idx, List<Integer> list) {
        if( target == 0 ) {
            result.add(new ArrayList<>(list));
            return;
        }
        if( target < 0 || idx >= candidates.length ) {
            return;
        }
        helper(candidates, target, idx+1, list);
        list.add(candidates[idx]);
        helper(candidates, target-candidates[idx], idx, list);
        list.remove(list.size()-1);
        
    }
}