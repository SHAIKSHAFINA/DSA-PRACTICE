class Solution {
    static class Pair{
        int val1;
        int index;
        int val2;
        Pair(int v1,int idx,int v2){
            val1 = v1;
            index = idx;
            val2 = v2;
        }
    }
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;

        ArrayList<Pair> sc=new ArrayList<>();
        for(int i=0;i<n;i++){
            sc.add(new Pair(nums1[i],i,nums2[i]));
        }
        Collections.sort(sc,(a,b)->a.val1-b.val1);
        long[] f=new long[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long sum=0;

        for(int i=0;i<n;i++){
            Pair p=sc.get(i);
           int x=p.val1;
           int idx=p.index;
            int j=p.val2;


            if(i>0 && sc.get(i).val1 ==sc.get(i-1).val1){
                f[idx]=f[sc.get(i-1).index];
            }
            else{
                f[idx]=sum;
            }
           
            pq.add(j);
            sum+=j;


            if(pq.size() > k){
                int z=pq.poll();
                sum-=z; 
            }

        }
        return f;


    }
}