class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][5];

        for(int i=0;i<=n;i++){
            dp[i][4]=0;
        }

        for(int t=0;t<4;t++){
            dp[n][t]=0;
        }

        for(int i=n-1;i>=0;i--){
            for(int t=0;t<4;t++){
                if(t%2==0){
                    dp[i][t]= Math.max(-prices[i]+ dp[i+1][t+1] , dp[i+1][t]);
                }
                else{
                     dp[i][t]= Math.max(prices[i]+ dp[i+1][t+1] , dp[i+1][t]);
                }
            }
        }
        return dp[0][0];
    }
}