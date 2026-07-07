class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        long sum=0;
        if(n==0) return 0;

        while(n>0){
            int d=n%10;
            sum+=d;
            if(d!=0){
                sb.append(d);
            }
            n=n/10;
        }
        sb.reverse();
        long x=Long.parseLong(sb.toString());
        return x*sum;
    }
}