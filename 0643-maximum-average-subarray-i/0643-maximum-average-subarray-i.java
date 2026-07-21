class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0,max=Integer.MIN_VALUE;
        int l=0,r=0;

        while(r<n){
            sum+=nums[r];
            while((r-l+1)>k){
                sum-=nums[l];
                l++;
            }
            if((r-l+1)==k){
                max=Math.max(max,sum/k);
            }
            r++;
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}