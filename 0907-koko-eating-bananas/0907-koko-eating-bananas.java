class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
       
        int max=piles[0];
        for(int i=0;i<n;i++){
            max=Math.max(piles[i],max);
        }
        int ans=0;
        int l=1,r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            double x=func(piles,mid);
            
            if(x<=h){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
    return ans;

    }

    double func(int piles[],int h){
        double t=0;
        for(int i=0;i<piles.length;i++){
            t+=Math.ceil((double)piles[i]/(double)h);
        }
        return t;
    }
}