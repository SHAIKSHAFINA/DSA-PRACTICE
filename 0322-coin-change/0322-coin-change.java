class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[]=new int[amount+1];


        for(int j=1; j<=amount; j++){
            dp[j] = Integer.MAX_VALUE - 1;
        }


        for(int i=1;i<=n;i++){
            for(int j=coins[i-1];j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[j]=Math.min(1+dp[j-coins[i-1]] , dp[j]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE -1){
            return -1;
        }

        return dp[amount];
    }
}