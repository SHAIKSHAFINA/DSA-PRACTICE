class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        if(k== nums.length){
            return nums;
        }
        HashMap<Integer,Integer> mp= new HashMap<>();

        for(int n:nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }

        Queue<Integer> q = new PriorityQueue<>(
           (a,b)->mp.get(a)-mp.get(b));

        for(int n:mp.keySet()){
            q.add(n);
            if(q.size()>k){
                q.poll();
            }
        }

        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=q.poll();
        }

        return arr;

    }
}