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
            long x=func(piles,mid);
            
            if(x<=h){
                
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
    return l;

    }

    long func(int piles[],int h){
        long t=0;
        for(int i=0;i<piles.length;i++){
           t += (piles[i] + h - 1) / h;
        }
        return t;
    }
}