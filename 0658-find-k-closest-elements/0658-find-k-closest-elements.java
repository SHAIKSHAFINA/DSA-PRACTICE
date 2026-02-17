class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int n=arr.length;
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }
            else{
                return b[1]-a[1];
            }
       });

       for(int i=0;i<n;i++){
            int dist=Math.abs(arr[i]-x);
            int val=arr[i];
            pq.add(new int[]{dist,val});
            if(pq.size()>k){
                pq.poll();
            }
       } 

       
       List<Integer> mp=new ArrayList<>();

       for(int i=0;i<k;i++){
        mp.add(pq.poll()[1]);
       }
       Collections.sort(mp);
       return mp;
    }
}