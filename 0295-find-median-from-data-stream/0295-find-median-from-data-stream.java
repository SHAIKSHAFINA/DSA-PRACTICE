class MedianFinder {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH=new PriorityQueue<>();
        maxH=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {

        maxH.add(num);
        minH.add(maxH.poll());

         if(minH.size() > maxH.size()){
            maxH.add(minH.poll());
        }
    }
    
    public double findMedian() {
        
        if(maxH.size()==minH.size()){
            return (double)(minH.peek()+maxH.peek())/2;
        }

        return maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */