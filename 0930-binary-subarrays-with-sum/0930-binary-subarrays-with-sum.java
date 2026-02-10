class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        //if(goal==0) return 0;
        return subArray(nums,goal)-subArray(nums,goal-1);

    }
    int subArray(int[] nums, int goal){
        int n=nums.length;
        int l=0,r=0,s=0,c=0;
        if(goal<0) return 0;

        while(r<n){
            s+=nums[r];
            while(s>goal){
                s-=nums[l];
                l++;
            }
            c+=(r-l+1);
            r++;
        }

        return c;
    }
}