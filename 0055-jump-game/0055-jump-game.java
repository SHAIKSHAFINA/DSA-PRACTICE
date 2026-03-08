class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int f=0;

        for(int i=0;i<n;i++){
            if(i>f){
                return false;
            }
            f=Math.max(f,i+nums[i]);
        }

        return f>=n-1;
    }
}