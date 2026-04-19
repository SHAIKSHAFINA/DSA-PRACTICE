class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> mp=new HashSet<>(wordDict);
        int n=s.length();
        ArrayList<String> l=new ArrayList<>();
        List<String> sc=new ArrayList<>();
        solve(s,mp,0,n,l,sc);
        return sc;

    

    }

    void solve(String s,HashSet<String> mp,int start,int n,ArrayList<String>l,List<String>sc){
        if(start==n){
            sc.add(String.join(" ",l));
            return;
        }

        for(int i=start;i<n;i++){
            String t=s.substring(start,i+1);
            if(mp.contains(t)){
                l.add(t);
                solve(s,mp,i+1,n,l,sc);
                l.remove(l.size()-1);
            }
        }
        return;
    }
}