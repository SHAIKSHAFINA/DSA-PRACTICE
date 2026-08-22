class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,pro=1 , c=n;

        while(n>0){
            int d=n%10;
            sum+=d;
            pro*=d;
            n/=10;
        }

        int total=sum+pro;

        if((c%total)==0) return true;
        return false;
    }
}