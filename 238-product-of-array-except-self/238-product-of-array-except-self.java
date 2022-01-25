class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] L = new int[N];
        int right = 1;
        L[0] = 1;
        for(int i = 1; i < N; i++) {
            L[i] = L[i-1]*nums[i-1];
        }
        for(int i = N-1; i >= 0; i--) {
            L[i] = L[i]*right;
            right = right * nums[i];
        }
        return L;
    }
}