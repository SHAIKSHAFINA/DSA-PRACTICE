class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,r=0;
        HashSet<Character> sc=new HashSet<>();
        int max=0;

        while(r<n){
            char c=s.charAt(r);
            if(!sc.contains(c)){
                max=Math.max(max,r-l+1);
            }
            else{
                while(sc.contains(c)){
                    sc.remove(s.charAt(l));
                     l++;
                }
            }
            sc.add(c);
            r++;
        }
        return max;
    }
}