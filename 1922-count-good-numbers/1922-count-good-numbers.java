class Solution {
    public int countGoodNumbers(long n) {
       
        long even=0,odd=0;
        long mod=1000000007;
        

        if(n%2==0){
            even+=n/2;
            odd+=n/2;
        }
        else{
           even+=n/2+1;
            odd+=n/2;
        }
        
        long ans=((long) power(5,even)%mod * (long)power(4,odd)%mod) % mod;
        return (int)ans;
    }

    long power(int x,long N){
        long mod=1000000007;
        if(N==0) return 1;
        long half=power(x,N/2);

        if(N%2==0){
            return ((long)half %mod * (long)half%mod) % mod;
        }
        else{
            return ((long)half %mod * (long)half%mod * x % mod) % mod;
        }
    }


}