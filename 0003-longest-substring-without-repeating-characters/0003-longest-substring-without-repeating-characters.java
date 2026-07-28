class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,r=0;
        HashSet<Character> mp=new HashSet<>();
        int max=0;

        while(r<n){
            while(mp.contains(s.charAt(r))){
                mp.remove(s.charAt(l));
                l++;
            }
            mp.add(s.charAt(r));
            max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
}