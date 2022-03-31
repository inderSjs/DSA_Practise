class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0 , nums.length-1);
        return nums;
    }
    
    public void sort(int[] arr, int start, int end) {
        if( end > start) {
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
        for(int i = 0; i < n2; i++) {
            R[i] = arr[m+1+i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while( i < n1 && j < n2) {
            if( L[i] <= R[j] ) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while( i < n1 ) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while( j < n2 ) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}