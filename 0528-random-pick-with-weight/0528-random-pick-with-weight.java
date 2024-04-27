class Solution {
    private int[] prefixSums;
    private int sum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        int temp = 0;
        for(int i = 0; i < w.length; i++) {
            temp = temp + w[i];
            this.prefixSums[i] = temp;
        }
        this.sum = temp;
    }
    
    public int pickIndex() {
        double target = this.sum * Math.random();
        for(int i = 0; i < prefixSums.length; i++) {
            if( prefixSums[i] > target) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */