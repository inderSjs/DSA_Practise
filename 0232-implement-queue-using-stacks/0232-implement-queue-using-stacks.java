class MyQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> auxStack;
    private int counter;

    public MyQueue() {
        mainStack = new Stack<Integer>();
        auxStack = new Stack<Integer>();
        counter = 0;
    }
    
    public void push(int x) {
        if( counter == 0 ) {
            mainStack.push(x);
            counter++;
            return;
        }
        while( !mainStack.isEmpty() ) {
            int temp = mainStack.pop();
            auxStack.push(temp);
        }
        mainStack.push(x);
        while( !auxStack.isEmpty() ) {
            int temp1 = auxStack.pop();
            mainStack.push(temp1);
        }
        counter++;
    }
    
    public int pop() {
        return mainStack.pop();
    }
    
    public int peek() {
        return mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
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