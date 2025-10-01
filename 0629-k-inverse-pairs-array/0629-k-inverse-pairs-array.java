class Solution {
    public int kInversePairs(int n, int k) {
        long[][]dp=new long[n+1][k+1];
        dp[1][0]=1;
        long MOD=1000000007;
        //int inv=n*(n-1)/2;
        for(int j=1;j<k;j++){
            dp[1][j]=0;
        }
        // dp[n][inv]=1;
        // dp[n][0]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0) dp[i][0]=1;
                else{
                    dp[i][j] =(dp[i][j-1] + dp[i-1][j] - ((j-i>= 0 )? dp[i-1][j-i] : 0)+MOD)%MOD;
                }
            }
        }
        return (int)dp[n][k];
    }
}