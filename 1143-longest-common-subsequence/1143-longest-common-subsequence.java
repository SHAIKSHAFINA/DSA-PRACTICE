class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
       
        int dp[]=new int[m+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int prevDia=0;
            for(int j=1;j<=m;j++){
                 int temp=dp[j];
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j]=1+prevDia;
                }
                else{
                    dp[j]=Math.max(temp,dp[j-1]);
                }
                prevDia=temp;
            }
        }


        return dp[m];
    }
}