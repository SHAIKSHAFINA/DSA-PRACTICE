class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int dp[][]=new int[n][n+1];
        
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        return recurr(s,0,0,dp);
    }

    boolean recurr(String s,int i,int co , int[][]dp){
        int n=s.length();
        if(i==n){
            return co==0;
        }
        if(co<0) return false;
        if(dp[i][co] !=-1) return dp[i][co]==1;
        
        char c=s.charAt(i);

        if(co<0) return false;
        boolean result;
        
         if(c=='('){
            result= recurr(s,i+1,co+1,dp);
        }
        else if(c==')'){
            result= recurr(s,i+1,co-1,dp);
        }
        else{
             result=recurr(s,i+1,co+1,dp) || recurr(s,i+1,co-1,dp) || recurr(s,i+1,co,dp);
        }
        dp[i][co]=result?1:0;
        return result;

        

    }
}