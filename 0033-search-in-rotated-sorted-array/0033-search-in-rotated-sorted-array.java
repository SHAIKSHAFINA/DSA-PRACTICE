class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int idx=n-1;

        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                idx=i;
                break;
            }
        }

        int x=binary(0,idx,nums,target);
        int y=binary(idx+1,n-1,nums,target);

        if(x!=-1){
            return x;
        }
        else if(y!=-1){
            return y;
        }
        return -1;

    }

    int binary(int l,int r,int[] nums,int target){
        int n=nums.length;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r--;
            }
            else{
                l++;
            }
        }
        return -1;
    }
}