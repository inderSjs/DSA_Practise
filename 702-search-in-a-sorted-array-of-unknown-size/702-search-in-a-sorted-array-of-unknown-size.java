/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int x = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        while( true ) {
            if( target > reader.get(right) ) {
                left = right;
                right = right * 2;
                //left = right;
            } else {
                break;
            }
        }
        while( left <= right ) {
            int pivot = left + (right - left)/2;
            if( reader.get(pivot) == target ) {
                return pivot;
            } else if ( target < reader.get(pivot) ) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        //System.out.println(reader.get(0));
        return -1;
    }
}