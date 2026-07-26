class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int x=nums[n-1]*nums[n-2]*nums[n-3];
        int y=nums[n-1]*nums[0]*nums[1];
        return Math.max(x,y);
    }
}