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

        Pair[] arr=new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=(new Pair(nums1[i],i,nums2[i]));
        }
        Arrays.sort(arr,(a,b)->a.val1-b.val1);
        long[] f=new long[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long sum=0;

        for(int i=0;i<n;i++){
            Pair p=arr[i];
           int x=p.val1;
           int idx=p.index;
            int j=p.val2;


            if(i>0 && arr[i].val1 ==arr[i-1].val1){
                f[idx]=f[arr[i-1].index];
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