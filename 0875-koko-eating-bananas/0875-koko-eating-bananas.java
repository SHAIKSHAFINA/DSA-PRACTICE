class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        int l=1,r=max;

        while(l<r){
            int mid=l+(r-l)/2;
            if(solve(mid,piles,h,n)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    boolean solve(int mid,int[]piles,int h,int n){
        long c=0;

        for(int i=0;i<n;i++){
            c+=(piles[i]+mid-1)/mid;
        }
        if(c>h) return false;

        return true;
    }
}