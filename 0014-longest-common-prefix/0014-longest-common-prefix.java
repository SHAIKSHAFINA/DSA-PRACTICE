class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String s=strs[0];

        for(int i=1;i<n;i++){
            String x=strs[i];
            while(!x.startsWith(s)){
                s=s.substring(0,s.length()-1);

                if(s.isEmpty()){
                    return "";
                }
            }
        }
        return s;
    }
}