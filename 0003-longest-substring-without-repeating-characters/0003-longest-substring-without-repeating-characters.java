class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,r=0;
        HashSet<Character> mp=new HashSet<>(); 
        long max=Long.MIN_VALUE;
        
        while(r<n){
            while(mp.contains(s.charAt(r))){
                mp.remove(s.charAt(l));
                l++;
            }
             mp.add(s.charAt(r));
            max=Math.max(max,r-l+1);
            r++;
        }
        
        return (int)max;
    }
}