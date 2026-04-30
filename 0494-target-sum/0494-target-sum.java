class Solution {
    public int findTargetSumWays(int[] arr, int target) {
         int sum=0;
         int n=arr.length;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        if(sum < Math.abs(target)) return 0;
        if((sum+target) % 2!=0) return 0;
        
        int result=(sum+target)/2;
        int dp[]= new int[result+1];


        dp[0]=1;


        for(int i=1;i<=n;i++){
            for(int j=result;j>=arr[i-1];j--){
                dp[j]=dp[j-arr[i-1]] + dp[j];  
            }
        }


        return dp[result];
    }
}