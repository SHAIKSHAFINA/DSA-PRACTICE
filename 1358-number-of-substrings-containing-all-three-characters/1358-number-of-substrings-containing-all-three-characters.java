class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int c=0;
        int hash[]=new int[3];
        int l=0,r=0;
        

        while(r<n){
            hash[s.charAt(r)-'a']++;
            while(hash[0]>0 && hash[1]>0 && hash[2]>0){
                    c+=n-r;
                    hash[s.charAt(l)-'a']--;
                    l++;
                
            }
            r++;
        }
        return c;
    }
}