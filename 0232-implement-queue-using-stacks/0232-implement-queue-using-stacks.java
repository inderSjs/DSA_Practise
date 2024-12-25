class MyQueue {
    private Stack<Integer> st;
    private Stack<Integer> helper;

    public MyQueue() {
        this.st = new Stack<>();
        this.helper = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while( !st.isEmpty() ) {
            helper.push(st.pop());
        }
        int ans = helper.pop();
        while( !helper.isEmpty() ) {
            st.push(helper.pop());
        }
        return ans;
    }
    
    public int peek() {
        while( !st.isEmpty() ) {
            helper.push(st.pop());
        }
        int ans = helper.peek();
        while( !helper.isEmpty() ) {
            st.push(helper.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */