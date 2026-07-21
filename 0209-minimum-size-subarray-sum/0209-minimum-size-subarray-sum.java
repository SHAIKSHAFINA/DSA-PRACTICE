class Solution {
    public int minSubArrayLen(int x, int[] arr) {
        int n=arr.length;
        int l=0,r=0;
        int sum=0,min=Integer.MAX_VALUE;
        
        while(r<n){
            sum+=arr[r];
            while(sum>=x){
                min=Math.min(min,r-l+1);
                sum-=arr[l];
                l++;
            }
            r++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}