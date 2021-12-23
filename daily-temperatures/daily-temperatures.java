class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] result = new int[N];
        boolean bool = false;
        for(int i = 0; i < N; i++) {
            int j = i + 1;
            while( j < N) {
                if( temperatures[j] > temperatures[i]) {
                    int k = j - i;
                    result[i] = k;
                    bool = true;
                    break;
                } else {
                    j++;
                }
            }
            if( !bool ) {
                result[i] = 0;
            } else {
                bool = false;
            }
        }
        return result;
    }
}