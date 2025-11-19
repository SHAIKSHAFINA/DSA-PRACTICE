class Solution {
    public int minLengthAfterRemovals(String s) {
        int n=s.length();

        int r=0 , c1=0,c2=0;
        while(r<n){
            if(s.charAt(r)=='a'){
                c1++;
            }
            if(s.charAt(r)=='b'){
                c2++;
            }
            r++;
        }
        return Math.abs(c1-c2);
    }
}