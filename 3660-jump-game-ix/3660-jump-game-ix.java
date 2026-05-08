class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int prevMax[]=new int[n];
        int suffMin[]=new int[n];
        
        prevMax[0]=nums[0];
        for(int i=1;i<n;i++){
            prevMax[i]=Math.max(prevMax[i-1],nums[i]);
        }

        suffMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffMin[i]=Math.min(suffMin[i+1],nums[i]);
        }

        int ans[]=new int[n];
        ans[n-1]=prevMax[n-1];

        for(int i=n-2;i>=0;i--){
            if(prevMax[i]<=suffMin[i+1]){
                ans[i]=prevMax[i];
            }
            else{
                ans[i]=ans[i+1];
            }
        }
        return ans;
    }
}