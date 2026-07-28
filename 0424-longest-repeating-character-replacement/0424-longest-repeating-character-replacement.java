class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0,r=0;

        int freq[]=new int[26];
        int maxF=0,max=0;

        while(r<n){
            char ch=s.charAt(r);
            freq[ch-'A']++;
            maxF=Math.max(maxF,freq[ch-'A']);

            while(((r-l+1)-maxF) >k){
                char x=s.charAt(l);
                freq[x-'A']--;
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;

        }

        return max;
    }
}