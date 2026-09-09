class Solution {
    public long countCommas(long n) {
        long ans=0;
        long power=1000;
        int c=1;

        while(power <= n){
            ans+=(n-power+1);
            power*=1000;
            c++;
        }

        return ans;
    }
}