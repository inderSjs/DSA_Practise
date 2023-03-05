class Solution {
    
    public int findFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while( low <= high ) {
            int mid = low + (high-low)/2;
            if( arr[mid] == target) {
                if( mid == 0 || arr[mid-1] != target) {
                    return mid;
                }
                if( arr[mid-1] == target ) {
                    high = mid - 1;
                }
            } else if( arr[mid] < target ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int findLast(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int n = high;
        while( low <= high ) {
            int mid = low + (high-low)/2;
            if( arr[mid] == target) {
                if( mid == n || arr[mid+1] != target) {
                    return mid;
                }
                if( arr[mid+1] == target ) {
                    low = mid + 1;
                }
            } else if( arr[mid] < target ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if( nums.length == 0 ) {
            return result;
        }
        int x = findFirst(nums, target);
        int y = findLast(nums, target);
        return new int[]{x,y};
    }
    
}