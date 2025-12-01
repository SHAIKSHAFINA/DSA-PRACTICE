class Solution {
    public int countElements(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int i=0;
        int c=0;
        while(i<n){
            int j=i;
            while(j+1<n && nums[i]==nums[j+1]){
                j++;
            }
            int block=j-i+1;
            int count=n-1-j;

            if(count>=k){
               c+=block; 
            }
            i=j+1;
        }
        return c;
           
    }
}