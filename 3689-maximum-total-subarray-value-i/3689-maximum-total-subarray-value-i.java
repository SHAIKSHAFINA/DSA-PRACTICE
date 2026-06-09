class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        long ans= (max-min) * k;
        return ans;
    }
}