class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> sc=new HashSet<>();
        int l=0,r=0,max=0;

        while(r<n){
            char c=s.charAt(r);

            while(sc.contains(c)){
                char left=s.charAt(l);
                sc.remove(left);
                l++;
            }

             if(!sc.contains(c)){
                sc.add(c);
                max=Math.max(max,r-l+1);
            }
            r++;
        }

        return max;

    }
}