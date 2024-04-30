class Solution {
    public int calculate(String s) {
        return helper(s);
    }
    
    private int helper(String str) {
        int n = str.length();
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int curr = 0;
        for(int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if( Character.isDigit(c) ) {
                curr = curr*10 + c - '0';
            }
            if( (!Character.isDigit(c) && c != ' ') || i == n-1) {
                if( lastSign == '+') {
                    st.push(curr);
                } else if( lastSign == '-') {
                    st.push(-curr);
                } else if( lastSign == '*'){
                    int popped = st.pop();
                    st.push(popped*curr);
                } else {
                    int popped = st.pop();
                    st.push(popped/curr);
                }
                lastSign = c;
                curr = 0;
            }
        }
        int result = 0;
        while( !st.isEmpty() ) {
            result = result + st.pop();
        }
        return result;
    }
}