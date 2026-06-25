class MyQueue {
    Stack<Integer> i;
    Stack<Integer> o;
    int peekEle=-1;

    public MyQueue() {
        i=new Stack<>();
        o=new Stack<>();
    }
    
    public void push(int x) {
        if(i.size()==0){
            peekEle=x;
        }
        i.push(x);
    }
    
    public int pop() {
        if(o.size()!=0){
            return o.pop();
        }
        else{
            while(i.size()!=0){
                o.push(i.pop());
            }

            return o.pop();
        }
    }
    
    public int peek() {
        if(o.size()!=0){
            return o.peek();
        } 
        else{
            return peekEle;
        }
    }
    
    public boolean empty() {
        if(i.size()==0 && o.size()==0) return true;
        return false;
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