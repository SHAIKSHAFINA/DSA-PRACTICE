class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Boolean dp[][]=new Boolean[n][n+1];
        
        return recurr(s,0,0,dp);
    }

    boolean recurr(String s,int i,int co , Boolean[][]dp){
        int n=s.length();
        if(i==n){
            return co==0;
        }
        if(co<0) return false;
        if(dp[i][co] !=null) return dp[i][co];
        
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
        dp[i][co]=result;
        return result;

        

    }
}