class MyStack {
    
    StackNode root; 
  
    static class StackNode { 
        int data; 
        StackNode next; 
  
        StackNode(int data) 
        { 
            //Constructor here
            this.data = data;
        } 
    } 

    public MyStack() {
        
    }
    
    public void push(int x) {
        StackNode node = new StackNode(x);
        if( root == null ) {
            root = node;
            return;
        }
        StackNode temp = root;
        node.next = temp;
        root = node;
    }
    
    public int pop() {
        if( root == null ) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            StackNode temp = root;
            if( temp.next == null) {
                root = null;
                return temp.data;
            }
            root = temp.next;
            return temp.data;
        }
    }
    
    public int top() {
         if( root == null ) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return root.data;
        }
    }
    
    public boolean empty() {
        if( root == null ) {
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