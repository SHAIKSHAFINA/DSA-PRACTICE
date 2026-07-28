class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0,r=n-1;
        int max=Integer.MIN_VALUE,area=0;

        while(l<=r){
            int x=height[l];
            int y=height[r];

            area=Math.min(height[l],height[r])*(r-l);
            max=Math.max(max,area);

            if(x<=y){
                l++;
            }
            else{
                r--;
            }
        }

        return max;
    }
}