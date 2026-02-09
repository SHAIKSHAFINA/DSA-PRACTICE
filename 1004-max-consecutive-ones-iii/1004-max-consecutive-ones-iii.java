class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;

        int l=0,r=0,max=0,c=0;
        while(r<n){
            int x=nums[r];
            if(x==0){
                c++;
            }
            while(c>k){
                int y=nums[l];
                if(y==0){
                    c--;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;

        }
        return max;
    }
}