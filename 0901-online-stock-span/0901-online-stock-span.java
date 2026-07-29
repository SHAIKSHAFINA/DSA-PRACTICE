class StockSpanner {
    Stack<int[]> st=new Stack();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int pair[]=new int[2];
         int c=1;
    
        while(!st.isEmpty()&& st.peek()[0]<=price){
            c+=st.peek()[1];
            st.pop();
        }
        pair[0]=price;
        pair[1]=c;
    
        st.push(pair);
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */