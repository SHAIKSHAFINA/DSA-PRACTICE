class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(prices,1,2,0,n,dp);

    }

    int solve(int[] prices,int buy,int cap,int start,int n,int dp[][][]){
        if(start==n) return 0;
        if(cap==0) return 0;

        if(dp[start][buy][cap]!=-1){
            return dp[start][buy][cap];
        }
        if(buy==1){
            return dp[start][buy][cap]=Math.max(-prices[start]+solve(prices,0,cap,start+1,n,dp),
                solve(prices,1,cap,start+1,n,dp));
        }
        else{
            return dp[start][buy][cap]=Math.max(prices[start]+solve(prices,1,cap-1,start+1,n,dp),
                solve(prices,0,cap,start+1,n,dp));
        }
    }
}