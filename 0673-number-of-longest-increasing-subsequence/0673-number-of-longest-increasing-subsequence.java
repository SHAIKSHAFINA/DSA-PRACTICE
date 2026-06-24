class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;

        int dp[]=new int[n];
        int c[]=new int[n];
        dp[0]=1;
        c[0]=1;

        for(int i=1;i<n;i++){
            dp[i]=1;
            c[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+dp[j] > dp[i]){
                    dp[i]=1+dp[j];
                    c[i]=c[j];
                }
                else if(arr[i]>arr[j] && 1+dp[j]==dp[i]){
                    c[i]+=c[j];
                }
            }
        }
        int max=-1;
        int co=0;
        for(int x:dp){
            max=Math.max(max,x);
        }

        for(int i=0;i<n;i++){
            if(dp[i]==max){
                co+=c[i];
            }
        }
        return co;
    }
}