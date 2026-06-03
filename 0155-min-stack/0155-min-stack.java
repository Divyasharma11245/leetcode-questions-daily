class MinStack {
    Stack<Long> s = new Stack<>();
    long minVal = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push((long)val);
            minVal = val;
            return;
        }
        if(val<minVal){
            s.push(2L*val-minVal);
            minVal = val;
        }else{
            s.push((long)val);
        }
    }
    
    public void pop() {
        if(s.peek()<minVal){
            minVal = 2L*minVal-s.peek();
        }
        s.pop();
    }
    
    public int top() {
        if(s.peek()<minVal){
            return (int)minVal;
        }
        long val= s.peek();
        return (int)val;
        
    }
    
    public int getMin() {
        return (int)minVal;
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