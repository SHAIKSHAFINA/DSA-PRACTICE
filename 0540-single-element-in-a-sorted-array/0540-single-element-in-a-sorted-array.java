class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int l=0,r=n-1,ans=nums[0];

        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];

        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        while(l<=r){
            int mid=l+(r-l)/2;
            
             if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    r=mid-1;
                }
                else if(nums[mid]==nums[mid+1]){
                    l=mid+1;
                }
            }
            else{
                if(nums[mid]==nums[mid-1]){
                    l=mid+1;
                }
                else if(nums[mid]==nums[mid+1]){
                     r=mid-1;
                }
            }

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

        }
        return nums[l];
    }
}