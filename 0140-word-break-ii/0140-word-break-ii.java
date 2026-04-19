class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> mp=new HashSet<>(wordDict);
        int n=s.length();
       HashMap<Integer,List<String>> dp=new HashMap<>();

       List<String> base=new ArrayList<>();
       base.add("");
       dp.put(0,base);

        for(int i=1;i<=n;i++){
            List<String> sc=new ArrayList<>();
            for(int j=0;j<i;j++){
                String t=s.substring(j,i);
                if(dp.get(j)!=null && mp.contains(t)){
                    List<String> prev=dp.get(j);

                    for(String x:prev){
                        if(x.equals("")){
                            sc.add(t);
                        }
                        else{
                            sc.add(x +" "+ t);
                        }
                    }
                }
            }
            dp.put(i,sc);
        }

        return dp.get(n);

    }

}