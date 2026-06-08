class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();

        int l=0,r=0;
        int max=0;
        HashSet<Character> mp=new HashSet<>();
        while(r<n){
            char c=s.charAt(r);
            while(mp.contains(c)){
                mp.remove(s.charAt(l));
                l++;
            }

            mp.add(c);
            max=Math.max(max,r-l+1);
            r++;

        }

        return max;
    }
}