class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        dp[0]=0;
        
        for(int i=1;i<=n;i++){
            int one=1+dp[i-1];
            int two=Integer.MAX_VALUE;
            int three=Integer.MAX_VALUE;


            if(i>=2){
                two=4+dp[i-2];
            }

            if(i>=3){
                three=9+dp[i-3];
            }
            dp[i]=costs[i-1]+Math.min(one,Math.min(two,three));
        }

        return dp[n];
    }

}