class Solution {
    public int kInversePairs(int n, int k) {
        long[]prev=new long[k+1];
        long[]curr=new long[k+1];

       prev[0]=1;
        long MOD=1000000007;

        for(int i=2;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0) curr[j]=1;
                else{
                    curr[j] =(curr[j-1]+prev[j]-(j-i>=0 ? prev[j-i]:0)+MOD)%MOD;
                }
            }
            long temp[]=prev;
            prev=curr;
            curr=temp;
        }
        return (int)prev[k];
    }
}