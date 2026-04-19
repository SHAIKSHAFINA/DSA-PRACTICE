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

    boolean solve(String s,HashSet<String> mp,int start,int n,Boolean[] dp){
        if(start==n) return true;
        
        if(dp[start]!=null){
            return dp[start];
        }

        for(int i=start;i<n;i++){
            String t=s.substring(start,i+1);
            if(mp.contains(t) && solve(s,mp,i+1,n,dp)){
               dp[start]=true;
               return true;
            }
        }
        dp[start]=false;
        return false;

    }
}