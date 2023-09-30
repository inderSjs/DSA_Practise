class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int temp = n;
        for(int i = 0; i < n; i++) {
            if( citations[i] >= temp ) {
                return temp;
            }
            temp--;
        }
        return 0;
    }
}