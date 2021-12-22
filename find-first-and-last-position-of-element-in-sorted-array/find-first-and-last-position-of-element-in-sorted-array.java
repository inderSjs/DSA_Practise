class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if( nums.length == 0) {
            return result;
        }
        if( nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        if( nums.length == 1 && nums[0] != target) {
            
            return result;
        }
        
        //simple brute force solution
        boolean flag = false;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] == target && !flag) {
                flag = true;
                result[0] = i;
            }
            if( flag && nums[i] != target) {
                result[1] = i-1;
                break;
            }
            if( flag && i == (nums.length - 1)) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}