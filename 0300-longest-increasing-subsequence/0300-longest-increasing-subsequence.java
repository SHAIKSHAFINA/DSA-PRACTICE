class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(nums,0,-1,n,dp);
    }

    int solve(int[]nums,int i,int prev,int n,int dp[][]){
        
        if(i==n) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        dp[i][prev+1]=solve(nums,i+1,prev,n,dp);//not take

        if(prev==-1 || nums[i] > nums[prev]){
            dp[i][prev+1]= Math.max(dp[i][prev+1],1+solve(nums,i+1,i,n,dp));
        }
        return dp[i][prev+1];
    }
}