class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int pref[]=new int[n+1];
        pref[0]=0;
        int max=0;

        for(int i=1;i<=n;i++){
            pref[i]=pref[i-1]+gain[i-1];
            max=Math.max(max,pref[i]);
        }

        return max;
    }
}