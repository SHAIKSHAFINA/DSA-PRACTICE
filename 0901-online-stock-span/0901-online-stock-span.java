class StockSpanner {
    ArrayList<Integer>sc;

    public StockSpanner() {
        sc=new ArrayList<>();
    }
    
    public int next(int price) {
        
        sc.add(price);
        int c=1;
       for(int i=sc.size()-2;i>=0;i--){
            if(sc.get(i)<=price){
                c++;
            }
            else{
                break;
            }
       }
       return c;

    }
        
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */