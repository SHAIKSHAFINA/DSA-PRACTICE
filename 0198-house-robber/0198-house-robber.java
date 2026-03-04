class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        if(n==1){
            return nums[0];
        }
        
        int curr=nums[0];
        int next=Math.max(nums[0],nums[1]);
       
        
        
    for(int i=2;i<n;i++){
        int sum=Math.max(next,nums[i]+curr);
        curr=next;
        next=sum;
        
    }

    return next;
    }
}