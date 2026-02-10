class Solution {
    public int minimumRecolors(String blocks, int k) {
         int n=blocks.length();

        int l=0,r=0,min=Integer.MAX_VALUE,c=0;
        while(r<n){
            char x=blocks.charAt(r);
            if(x=='W'){
                c++;
            }
            while(r-l+1>k){
                if(blocks.charAt(l)=='W'){
                    c--;
                }
                l++;
            }
            if(r-l+1 ==k){
                min=Math.min(min,c);
            }
            r++;

        }
        return min;
    }
}