class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        
        // if(n==0) return 0;
        // if(n==1) return 0;

        int l=0,r=n-1;
        while(l<=r){
            int mid=(l+r)/2;

            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]<target){
                l++;
               
            }
            else if(nums[r]>=target){
                r--;
            }
        }
        return -1;
    }
}