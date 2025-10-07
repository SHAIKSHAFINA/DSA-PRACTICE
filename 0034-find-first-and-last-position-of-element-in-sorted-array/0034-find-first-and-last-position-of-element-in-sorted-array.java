class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;

        

        int l=0,r=n-1;
        int[]a={-1,-1};
        if(n==0) return a;
        
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]>=target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
            if(mid<n && nums[mid]==target){
                a[0]=mid;
            }
        }
        l=0;
        r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]<=target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }

            if(mid<n && nums[mid]==target){
                a[1]=mid;
            }
        }
        return a;
       
    }
}