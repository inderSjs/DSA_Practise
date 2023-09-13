class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < n; i++) {
            while( !st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int x = st.pop();
                result[x] = i - x;
            }
            st.push(i);
        }
        return result;
    }
}