class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int sum=0,lmax=0,rmax=n-1,max=0;

        for(int i=0;i<n;i++){
           if(height[max]<height[i]){
             max=i;
           }
        }

        for(int i=0;i<max;i++){
            if(height[i]>height[lmax]){
                lmax=i;
            }
            sum+=height[lmax]-height[i];
        }

        for(int i=n-2;i>max;i--){
            if(height[i]>height[rmax]){
                rmax=i;
            }
            sum+=height[rmax]-height[i];
        }
        return sum;

    }
}