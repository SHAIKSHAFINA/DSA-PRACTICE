class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int mid=nums[n/2];

        int sum=0;

        for(int i=0;i<n;i++){
            sum+=Math.abs(mid-nums[i]);
        }
        return sum;
    }
}