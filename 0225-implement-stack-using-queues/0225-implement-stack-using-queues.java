class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q=new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        //reverse(q);
    }
    
    public int pop() {
        reverse(q);
        int y= q.poll();
        reverse(q);
        return y;
    }
    
    public int top() {
        reverse(q);
        int y= q.peek();
        reverse(q);
        return y;
        
    }
    
    public boolean empty() {
        if(q.size()==0) return true;
        return false;
    }

    public void reverse(Queue <Integer> q){
        if(q.size()==0) return;
        int x=q.poll();
        reverse(q);
        q.offer(x);
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