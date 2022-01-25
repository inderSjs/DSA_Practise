class Solution {
    public int search(int[] nums, int target) {
        if( nums[0] == target) {
            return 0;
        }
        if( nums.length == 1 && nums[0] == target) {
            return 0;
        }
        if( nums.length == 1 && nums[0] != target) {
            return -1;
        }
        int i = findsmallest(nums, 0, nums.length-1);
        System.out.println(i);
        if( i == 0 ) {
            return binarySearch( nums, 0, nums.length - 1, target);
        }
        if( nums[0] >= target && nums[i] <= target) {
            return binarySearch(nums, i, nums.length-1, target);
        } else {
            System.out.println("Over here");
            return binarySearch(nums, 0, i-1, target);
        }
    }
    
    public int binarySearch(int[] nums, int start, int end, int target) {
        if( end <= start ) {
            if( nums[start] == target) {
                return start;
            } else {
                System.out.println("Over here");
                return -1;
            }
        }
        int pivot;
        while( start <= end) {
            pivot = start + ((end-start)/2);
            //System.out.println(pivot);
            if( nums[pivot] == target) {
                System.out.println("Over here");
                return pivot;
            }
            if( nums[pivot] > target) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
        }
        //System.out.println("Over here");
        return -1;
    }
    
    public int findsmallest(int[] nums, int start, int end) {
        if(nums[start] < nums[end]) {
            return 0;
        }
        int pivot;// = start + ( end - start)/2;
        while( start <= end ) {
            pivot = start + ( end - start)/2;
            if( nums[pivot] > nums[pivot+1]) {
                return (pivot+1);
            }
            if( nums[pivot] < nums[pivot-1] && nums[pivot] < nums[pivot+1]) {
                return pivot;
            }
            if( nums[pivot] > nums[start] ) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
        System.out.println("Over here");
        return 0;
    }
}