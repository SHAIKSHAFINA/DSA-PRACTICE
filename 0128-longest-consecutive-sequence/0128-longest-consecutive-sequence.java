class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int c=1,max=1;
        if(n==0) return 0;

        if(n==1) return 1;

        for(int i=0;i<n-1;i++){
            if(nums[i]+1==nums[i+1]){
                c++;
                max=Math.max(max,c);
            }
            else if(nums[i]==nums[i+1]){
               
            }
            else{
                 
                 c=1;
            }
        }
        return max;
    }
}