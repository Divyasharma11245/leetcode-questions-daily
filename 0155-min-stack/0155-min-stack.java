class MinStack {
    Stack<Long> s = new Stack<>();
    long minVal;
    public MinStack() {
        s = new Stack<>();
        minVal = 0;
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push((long)val);
            minVal = val;
        }else{
            if(val<minVal){
                s.push((long)2*val-minVal);
                minVal  = val;
            }else{
                s.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(s.peek()<minVal){
            minVal = 2*minVal-s.peek();
        }
        s.pop();
    }
    
    public int top() {
        if(s.peek()<minVal){
            return (int)minVal;
        }
        return s.peek().intValue();
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