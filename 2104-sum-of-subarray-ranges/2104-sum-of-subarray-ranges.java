class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        // int min=Integer.MAX_VALUE;
        // int max=Integer.MIN_VALUE;
        long sum=0;

        for(int i=0;i<n;i++){
           int min=nums[i];
            int max=nums[i];
            for(int j=i;j<n;j++){
                min=Math.min(min,nums[j]);
                max=Math.max(max,nums[j]);
                 sum+=(max-min);
            }
           
        }
        return sum;
    }
}