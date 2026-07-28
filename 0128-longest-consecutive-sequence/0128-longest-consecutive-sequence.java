class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        if(n==0) return 0;
        int c=1,max=1;

        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]-1){
                c++;
            }
            else if(nums[i]==nums[i+1]) continue;
            else{
                c=1;
            }
            max=Math.max(max,c);
        }
        return max;

    }
}