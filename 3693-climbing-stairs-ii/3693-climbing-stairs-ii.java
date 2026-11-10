class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return sum(0,n,costs,dp);
    }

    int sum(int i,int n,int[] costs,int dp[]){
        if(i==n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        int three=Integer.MAX_VALUE;


        if(i+1<=n){
            one=1+costs[i]+sum(i+1,n,costs,dp);
        }

        if(i+2<=n){
            two=4+costs[i+1]+sum(i+2,n,costs,dp);
        }
        if(i+3<=n){
            three=9+costs[i+2]+sum(i+3,n,costs,dp);
        }


        return dp[i]=Math.min(one,Math.min(two,three));
    }
}