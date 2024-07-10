class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
        this.min = 0;
        this.stack = new Stack();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push((long)(val - min));
            if (val - min < 0) {
                min = val;
            }
        }
    }
    
    public void pop() {
        long top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
        
    }
    
    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int)min;
        } else {
            return (int)(top + min);
        }
    }
    
    public int getMin() {
        return (int)min;
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