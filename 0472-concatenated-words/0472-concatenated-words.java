class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n=words.length;

        HashSet<String> mp=new HashSet<>(Arrays.asList(words));
        List<String> l=new ArrayList<>();

        for(String w:words){
            if(w.equals("")) continue;
            mp.remove(w);
             boolean dp[]=new boolean[w.length()+1];
             dp[0]=true;
            
            for(int i=1;i<=w.length();i++){
                for(int j=0;j<i;j++){
                    if(dp[j] && mp.contains(w.substring(j,i))){
                        dp[i]=true;
                        break;
                    }
                }
            }

            if(dp[w.length()]){
                l.add(w);
            }
            mp.add(w);
        }

        return l;
    }

}