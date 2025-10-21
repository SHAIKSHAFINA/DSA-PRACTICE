class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length,min=Integer.MAX_VALUE;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
       dp[0]=0;
        for(int i=0;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
           
        }
        if(dp[amount]<amount+1){
            return dp[amount];
        }
        else{
            return -1;
        }
       
    }
}