class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if( st.isEmpty() ) {
            st.push(val);
            minSt.push(val);
            min = val;
        } else {
            st.push(val);
            min = Math.min(min, st.peek());
            minSt.push(min);
        }
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        if( !minSt.isEmpty()) {
            min = minSt.peek();
        } else {
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */