class Solution {
    public double myPow(double x, int n) {
        double res=1;
        long exp=n;
        
        if(n<0){
           exp=Math.abs((long)n);
           x=1/x;
        }
        while(exp!=0){
            if(exp%2==1){
                 res*=x;
            }
            x*=x;
            exp/=2;
        }
        return res;
    }
}