class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int sum=0,max=Integer.MIN_VALUE;
        int l=0,r=0;

        while(r<n){
            sum+=nums[r];
            if((r-l+1)>k){
                sum-=nums[l];
                l++;
            }
            if((r-l+1)==k){
                max=Math.max(max,sum);
            }
            r++;
        }
        return max==Integer.MIN_VALUE?-1:(double)max/k;
    }
}