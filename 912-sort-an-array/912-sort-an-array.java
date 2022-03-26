class Solution {
    public int[] sortArray(int[] nums) {
        int mid = nums.length/2;
        int i = mid;
        int j = mid;
        while ( i >= 0 && j < nums.length ) {
            swap(nums, i, j);
            i--;
            j++;
        }
        sort(nums, 0 , nums.length-1);
        return nums;
    }
    
    public void sort(int[] arr, int start, int end) {
        if( start < end ) {
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot-1);
            sort(arr, pivot+1, end);
        }
    }
    
    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start-1;
        int j = start;
        while( j < end ) {
            if( arr[j] < pivot ) {
                i++;
                swap(arr, i, j);
               // i++;
               // j++;
            }
            j++;
        }
        swap(arr, i+1, end);
        return (i+1);
    }
    
    public void swap(int[] arr, int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}