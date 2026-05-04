class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(text1,text2,n,m,dp);
    }

    int solve(String s, String u,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(s.charAt(n-1)==u.charAt(m-1)){
            dp[n][m]= 1+solve(s,u,n-1,m-1,dp);
        }
        else{
            dp[n][m]= Math.max(solve(s,u,n-1,m,dp),solve(s,u,n,m-1,dp));
        }

        return dp[n][m];
    }
}