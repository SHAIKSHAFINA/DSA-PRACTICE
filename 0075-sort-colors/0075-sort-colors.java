class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0,r=n-1,mid=0;

        while(mid<=r){
            if(nums[mid]==0){
                swap(l,mid,nums);
                l++;
                mid++;
            }

            else if(nums[mid]==2){
                swap(r,mid,nums);
                r--;
            }
            else{
                mid++;
            }
        }
    }

    void swap(int i,int j,int nums[]){
       int temp= nums[i];
       nums[i]=nums[j];
       nums[j]=temp;
    }
}