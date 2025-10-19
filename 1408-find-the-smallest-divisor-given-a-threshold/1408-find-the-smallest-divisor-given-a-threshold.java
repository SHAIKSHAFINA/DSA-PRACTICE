class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
       
        int max=Integer.MIN_VALUE;

        for(int y:nums){
           
            if(y>max) max=y;
        }

        int l=1,r=max;

        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(divide(nums,threshold,mid)==true){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
         }
        return l;
    }

    boolean divide(int [] nums,int t,int x){
        int n=nums.length;
        int sum=0;
       for(int i=0;i<n;i++){
            sum+=(nums[i]+x-1)/x;
       }
       if(sum<=t){
            return true;
       }
       return false;
    }
}