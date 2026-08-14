class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        int l=0,r=0,max=0;

        while(r<n){
            char c=s.charAt(r);
            mp.put(c,mp.getOrDefault(c,0)+1);

            while(mp.get(c)>2){
                char x=s.charAt(l);
                mp.put(x,mp.getOrDefault(x,0)-1);
                if(mp.get(x)==0){
                    mp.remove(x);
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
}