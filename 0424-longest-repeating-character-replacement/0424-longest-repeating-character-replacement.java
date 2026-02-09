class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0,r=0,mf=0 ,max=0;
        HashMap<Character,Integer> sc=new HashMap<>();

        while(r<n){
            char c=s.charAt(r);
            sc.put(c,sc.getOrDefault(c,0)+1);
            mf=Math.max(mf,sc.get(c));
            
            while((r-l+1)-mf >k){
                sc.put(s.charAt(l) , sc.get(s.charAt(l))-1);
                l++;

            }
           
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}