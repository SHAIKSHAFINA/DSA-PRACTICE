class StockSpanner {
    Stack<int[]>st;
    int i;

    public StockSpanner() {
        st=new Stack<>();
        i=-1;
    }
    
    public int next(int price) {
        i=i+1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            st.pop();
        }
        int ans= i-(st.isEmpty()? -1:st.peek()[1]);
        st.push(new int[]{price,i});
       return ans;

    }
        
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */