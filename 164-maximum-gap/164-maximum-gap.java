class Solution {
    public int maximumGap(int[] nums) {
        if( nums.length < 2) {
            return 0;
        }
        
        if( nums.length == 2) {
            return nums[1] - nums[0];
        }
        sort(nums, 0, nums.length-1);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length-1; i++) {
            int j = i+1;
            if( (nums[j]-nums[i]) > max ) {
                max = (nums[j]-nums[i]);
            }
        }
        return max;
    }
    
    public void sort(int[] arr, int start, int end) {
        if( start < end ) {
            int mid = start + (end - start)/2;
            sort(arr, start, mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    
    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++) {
            L[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = arr[m+1+j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while ( i < n1 && j < n2 ) {
            if( L[i] < R[j] ) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while ( i < n1 ) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while ( j < n2 ) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}