class MinStack {
    Stack<Integer>s1,s2;
    public MinStack() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int val) {

        s1.push(val);
        if(s2.isEmpty()){
            s2.push(val);
        }

        else if(s1.peek()<=s2.peek()){
            s2.push(val);
        }
        else{
            s2.push(s2.peek());
        }
    }
    
    public void pop() {
        if(s1.size()==0 || s2.size()==0) return;
        s1.pop();
        s2.pop();
       
    }
    
    public int top() {
        if(s1.size()==0) return -1;
        return s1.peek();
    }
    
    public int getMin() {
        if(!s2.isEmpty())  
        {
            return s2.peek();
        }
        else{
            return -1;
        }
        
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