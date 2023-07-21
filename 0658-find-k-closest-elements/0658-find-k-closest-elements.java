class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //2 pointer solution
        int start = 0;
        int end = arr.length-1;
        List<Integer> result = new ArrayList<>();
        while( (end-start+1) > k ) {
            int distA = Math.abs(x - arr[start]);
            int distB = Math.abs(x - arr[end]);
            if( distA == distB ) {
                end--;
            } else if ( distA > distB ) {
                start++;
            } else {
                end--;
            }
        }
        for(int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}