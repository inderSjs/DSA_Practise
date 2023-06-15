class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        if( n == 1) {
            return s;
        }
        Stack<Character> st = new Stack<>();
        Stack<Integer> cnt = new Stack<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if( st.isEmpty() || st.peek() != c) {
                st.push(c);
                cnt.push(1);
            } else {
                int nCnt = cnt.pop() + 1;
                if( nCnt == k) {
                    st.pop();
                } else {
                    cnt.push(nCnt);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while( !st.isEmpty() ) {
            int x = cnt.pop();
            char c = st.pop();
            for(int i = 0; i < x; i++) {
                result.append(c);
            }
        }
        return result.reverse().toString();
    }
}