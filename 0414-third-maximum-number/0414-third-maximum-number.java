class Solution {
    public int thirdMax(int[] nums) {
        int n=nums.length;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashSet<Integer> sc=new HashSet<>();
        for(int x:nums){
            sc.add(x);
        }

        for(int val:sc){
            pq.add(val);
            if(pq.size() > 3){
                pq.poll();
            }
        }

        if(pq.size()<3){
            while(pq.size() >1){
                pq.poll();
            }
        }
        return pq.peek();
    }
}