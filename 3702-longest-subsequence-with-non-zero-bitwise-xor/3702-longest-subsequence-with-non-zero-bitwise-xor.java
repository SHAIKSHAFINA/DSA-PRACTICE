class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int x=0;
        boolean allZero=true;

        for(int i=0;i<n;i++){
            x^=nums[i];
            if(nums[i]!=0) allZero=false;
        }
            if(allZero) return 0;
            if(x!=0) return n;
            else if(n>1) return n-1;
            else return 0;
        
    }
}