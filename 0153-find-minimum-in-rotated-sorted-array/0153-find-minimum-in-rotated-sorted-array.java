class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0 , r=n-1, ans=nums[0];
       
            while(l<=r){
                if(nums[l]<nums[r]){
                    ans=Math.min(nums[l],ans);
			  break;
                }
                int mid=(l+r)/2;
                ans=Math.min(nums[mid],ans);
                if(nums[l]<=nums[mid]){
                    l=mid+1;
                }
                else{
                    r=mid-1;  
                }
            }
            return  ans;
    }
}
