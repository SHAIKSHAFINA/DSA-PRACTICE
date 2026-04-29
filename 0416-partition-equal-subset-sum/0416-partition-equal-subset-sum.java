class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        int target=sum/2;
        if(sum % 2!=0){
            return false;
        }

        boolean dp[]=new boolean[target+1];

        dp[0]=true;

        

        for(int i=1;i<=n;i++){
            for(int j=target;j>=0;j--){
                if(nums[i-1]<=j){
                    dp[j]=dp[j-nums[i-1]] || dp[j];
                }

            }
        }

        return dp[target];
    }
}