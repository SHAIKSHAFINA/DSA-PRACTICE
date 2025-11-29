class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long ans=0;
        if(dividend==divisor) return 1;
        if(dividend >=0 && divisor<0) sign=false;
        else if(dividend <=0 && divisor>0) sign=false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        while(n>=d){
            int cnt=0;
            while(n>= (d<<(cnt+1))){
                cnt++;
            }
                ans+=1<<cnt;
                n-=(d<<cnt);
            
        }
        if(ans>= (1L<<31) && sign){
            return Integer.MAX_VALUE;
        }

        if(ans>= (1L<<31) && !sign){
            return Integer.MIN_VALUE;
        }

        return (int)(sign?ans:-ans);

    }
}