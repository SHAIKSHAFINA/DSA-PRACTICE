class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;

        for(int x:nums){
             min=Math.min(min,x);
        }
        int c=0;
        for(int x:nums){
             c+=(x-min);
        }
        return c;
    }
}