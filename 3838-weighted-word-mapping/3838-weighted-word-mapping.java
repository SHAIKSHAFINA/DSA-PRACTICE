class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        StringBuilder sb=new StringBuilder();

        for(String s:words){
            int sum=0;
            for(char ch:s.toCharArray()){
                sum+=weights[ch-'a'];
                sum%=26;
            }
            sb.append((char)('z'-sum));
        }

        return sb.toString();
    }
}