class Solution {
    public int search(int[] nums, int target) {
        if( nums.length == 1 && nums[0] == target) {
            return 0;
        }
        if( nums.length == 1 && nums[0] != target) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int pivot;
        while( start <= end ) {
            pivot = start + (end - start)/2;
            if( nums[pivot] == target) {
                return pivot;
            }
            else if( nums[pivot] >= nums[start] ) {
                if(target < nums[pivot] && target >= nums[start]) {
                    end = pivot - 1;
                } else {
                    start = pivot + 1;
                }
            } else {
                if( target >= nums[pivot] && target <= nums[end]) {
                    start = pivot + 1;
                } else {
                    end = pivot - 1;
                }
            }
        }
        return -1;
    }
}