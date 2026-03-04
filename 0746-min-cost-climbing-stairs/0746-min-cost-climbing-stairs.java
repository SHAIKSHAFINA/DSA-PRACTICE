class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;

        int dp[]=new int[n+1];
        // dp[0]=cost[0];
        // dp[1]=cost[1];
        int prev=cost[0];
        int curr=cost[1];

        for(int i=2;i<n;i++){
            int sum=cost[i]+Math.min(prev,curr);
            prev=curr;
            curr=sum;
            //dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }

        return Math.min(curr,prev);
    }
}