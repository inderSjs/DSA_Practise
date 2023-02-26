class MyStack {
    
    static final int MAX = 1000; 
    int top; 
    int a[] = new int[MAX]; // Maximum size of Stack 

    public MyStack() {
        top = -1; //If stack is empty
    }
    
    public void push(int x) {
        if( top >= MAX ) {
            System.out.println("Stack Overflow");
            //return false;
        } else {
            top = top + 1;
            a[top] = x;
        }
        //return true;
    }
    
    public int pop() {
        if( top == -1 ) {
            System.out.println("Stack Underflow");
            return 0;
        }
        top = top - 1;
        return a[top+1];
    }
    
    public int top() {
        if( top == -1 ) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }
    
    public boolean empty() {
        if( top == -1 ) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */