class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> mp=new HashSet<>(wordDict);
        int n=s.length();
       HashMap<Integer,List<String>> dp=new HashMap<>();
       List<String> sc=new ArrayList<>();
        return solve(s,mp,0,n,dp);

    }

    List<String> solve(String s,HashSet<String> mp,int start,int n,HashMap<Integer,List<String>> dp){
        List<String> res=new ArrayList<>();
        if(start==n){
            List<String> sc=new ArrayList<>();
            sc.add("");
            return sc;
        }
        
        if(dp.get(start)!=null){
            return dp.get(start);
        }

        for(int i=start;i<n;i++){
            String t=s.substring(start,i+1);
            if(mp.contains(t)){
              List<String> next= solve(s,mp,i+1,n,dp);

              for(String x:next){
                if(x.equals("")){
                    res.add(t);
                }
                else{
                    res.add(t +" "+ x);
                }
              }
            }
        }
        dp.put(start,res);
        return res;

    }
}