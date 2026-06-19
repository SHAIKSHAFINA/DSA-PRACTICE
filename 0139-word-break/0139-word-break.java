class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> mp=new HashSet<>();

        for(String x:wordDict){
            mp.add(x);
        }
        int n=s.length();
        Boolean dp[]=new Boolean[n];
        return solve(s,mp,0,n,dp);
    }
    boolean solve(String s,HashSet<String> mp,int i,int n,Boolean [] dp){
        if(i==n){
            return true;
        }

        if(dp[i]!=null) return dp[i];

        for(int j=i;j<n;j++){
            String t=s.substring(i,j+1);
            if(mp.contains(t) && solve(s,mp,j+1,n,dp)){
                dp[i]=true;
                return true;
            }
        }

        dp[i]=false;
        return false;
    }
}