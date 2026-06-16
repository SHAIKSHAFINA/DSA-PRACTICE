class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);


        int l=0,r=0,c=0;

        while(l<n && r<m){
            if(g[l] <= s[r]){
                c++;
                l++;
                r++;
            }
            else{
                r++;
            }
            
        }

        return c;
    }
}