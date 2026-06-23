class MedianFinder {
    //MedianFinder m;
    PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> q=new PriorityQueue<>();

    public MedianFinder() {
      //  m=new MedianFinder();
    }
    
    public void addNum(int num) {
        p.add(num);
        q.add(p.poll());


        if(q.size()>p.size()){
            p.add(q.poll());
        }
    }
    
    public double findMedian() {
        int x=p.size()+q.size();

        if(x%2 !=0){
            return p.peek();
        }
        else{
            return (p.peek()+q.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */