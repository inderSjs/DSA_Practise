class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        int[] L = new int[N];
        int[] R = new int[N];
        L[0] = 1;
        R[N-1] = 1;
        for(int i = 1; i < N; i++) {
            L[i] = L[i-1]*nums[i-1];
        }
        for(int i = N-2; i >= 0; i--) {
            R[i] = R[i+1]*nums[i+1];
        }
        for(int i = 0; i < N; i++){
            result[i] = L[i] * R[i];
        }
        return result;
    }
}