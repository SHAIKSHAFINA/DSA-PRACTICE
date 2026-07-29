class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int n=nums.length;

        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            int b[]=new int[2];
            b[0]=entry.getKey();
            b[1]=entry.getValue();
            pq.add(b);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int []a=new int[pq.size()];

        for(int i=0;i<k;i++){
            int x[]=pq.poll();
            a[i]=x[0];
        }
        return a;
    }
}