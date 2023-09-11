class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        while( p1 < m && p2 < n) {
            if( nums1[p1] <= nums2[p2] ) {
                nums[idx] = nums1[p1];
                p1++;
            } else {
                nums[idx] = nums2[p2];
                p2++;
            }
            idx++;
        }
        while( p1 < m) {
            nums[idx] = nums1[p1];
            p1++;
            idx++;
        }
        while( p2 < n) {
            nums[idx] = nums2[p2];
            p2++;
            idx++;
        }
        int mid = (m+n-1)/2;
        if( (m+n)%2 == 0) {   
            return ( nums[mid] + nums[mid+1])/2.0;
        } else {
            return nums[mid]/1.0;
        }
    }
}