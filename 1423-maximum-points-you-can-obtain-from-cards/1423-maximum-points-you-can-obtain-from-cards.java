class Solution {
    public int maxScore(int[] arr, int k) {
        int n=arr.length;
        int l=0,r=0 , c=0 , sum=0 , s=0 ,min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            s+=arr[i];
        }

        while(r<n){
            sum+=arr[r];
            while((r-l+1)>n-k){
                sum-=arr[l];
                l++;
            }
            if(r-l+1==n-k){
                 min=Math.min(min,sum);
            }
            r++;
        }

        return s-min;
    }
}