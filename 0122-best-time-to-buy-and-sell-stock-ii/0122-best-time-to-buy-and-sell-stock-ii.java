class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return profit(prices,n,0,1,dp);
    }

    int profit(int prices[],int n,int start,int buy,int dp[][]){
        if(start==n){
            return 0;
        }

        if(dp[start][buy]!=-1){
            return dp[start][buy];
        }

        if(buy==1){
            return dp[start][buy] =Math.max(-prices[start]+profit(prices,n,start+1,0,dp) ,profit(prices,n,start+1,1,dp));
        }
        else{
            return dp[start][buy] =Math.max(prices[start]+profit(prices,n,start+1,1,dp) ,profit(prices,n,start+1,0,dp));
        }
        

    }
}