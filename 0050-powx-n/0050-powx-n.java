class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;
        long N=n;

        if(N<0){
            x=1/x;
            N=-N;
        }
        return (double)(power(x,n));

    }

    double power(double x,int n){
        if(x==0) return 0;
        if(n==0) return 1;
        double half=power(x,n/2);
        double xpow=0;
        if(n%2==0){
            xpow=half* half;
        }
        else{
            xpow=x* half * half;
        }
        return xpow;
    }
}