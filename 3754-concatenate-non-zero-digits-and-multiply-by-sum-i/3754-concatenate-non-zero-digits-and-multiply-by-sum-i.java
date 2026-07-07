class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        long sum=0;
        if(n==0) return 0;
        long x=0;

        while(n>0){
            long d=n%10;
            sum+=d;
            if(d!=0){
                x=x*10+d;
            }
            n=n/10;
        }
        long rev=0;
        while(x>0){
            long d=x%10;
            rev=rev*10+d;
            x=x/10;
        }

        return rev*sum;
    }
}