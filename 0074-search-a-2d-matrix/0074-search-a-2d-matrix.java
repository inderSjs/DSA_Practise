class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean check = false;
        int m = matrix.length;
        int n = matrix[0].length;
       // if( m == 1 && n == )
        if( target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        int i = 0;
        while( i < m ) {
            if( target >= matrix[i][0] && target <= matrix[i][n-1]) {
                check = true;
                return binarySearch(matrix[i], 0, n-1, target);
            }
            i++;
        }
        if( !check ) {
            return false;
        }
        return true;
    }
    
    public boolean binarySearch(int[] arr, int l, int r, int target) {
        if( l == r ) {
            if( arr[l] == target ) {
                return true;
            } else {
                return false;
            }
        }
        if( l < r ) {
            int mid = l + (r-l)/2;
            if( arr[mid] == target ) {
                return true;
            } else if ( target < arr[mid] ) {
                return binarySearch(arr, l, mid-1, target);
            } else {
                return binarySearch(arr, mid+1, r, target);
            }
        }
        return false;
    }
}