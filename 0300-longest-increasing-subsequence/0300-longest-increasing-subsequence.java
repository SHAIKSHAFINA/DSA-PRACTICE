class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int prev[]=new int[n+1];
        int curr[]=new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int len=0+prev[j+1];
                if(j==-1 || nums[i] > nums[j]){
                    len= Math.max(len,1+prev[i+1]);
                }
                curr[j+1]=len;
            }

            prev=curr;
        }

        return curr[-1+1];
    }
}