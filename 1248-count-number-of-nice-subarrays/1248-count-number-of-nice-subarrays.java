class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        return subArray1(nums,k)-subArray2(nums,k-1);
    }

    int subArray1(int[]nums , int k){
        int l=0,r=0,n=nums.length;
        int ps=0,c=0;
        if(k<0) return 0;

        while(r<n){
            if(nums[r]%2==0){
                nums[r]=0;
            }
            else{
                nums[r]=1;
            }

            ps+=nums[r];
            while(ps>k){
                ps-=nums[l];
                l++;
            }
            c+=(r-l+1);
            r++;
        }
        return c;

    }
    int subArray2(int[]nums , int k){
        int l=0,r=0,n=nums.length;
        int ps=0,c=0;
        if(k<0) return 0;

        while(r<n){
            if(nums[r]%2==0){
                nums[r]=0;
            }
            else{
                nums[r]=1;
            }

            ps+=nums[r];
            while(ps>k){
                ps-=nums[l];
                l++;
            }
            c+=(r-l+1);
            r++;
        }
        return c;

    }
}