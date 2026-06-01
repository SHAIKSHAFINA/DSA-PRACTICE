class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ans=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                ans=i;
                break;
            }
        }

        if(ans==-1){
            reverse(0,n-1,nums);
            return;
        }

        for(int j=n-1;j>ans;j--){
            if(ans!=-1 && nums[j]>nums[ans]){
                swap(j,ans,nums);
                break;
            }
        }

        reverse(ans+1,n-1,nums);


    }

    void swap(int a,int b,int nums[]){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    void reverse(int i,int j,int nums[]){
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
}