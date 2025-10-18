class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        if(n<m*k) return -1;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
       
        int l=min,r=max,ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(possible(bloomDay,mid,m,k)==true){
                ans=mid;
                r=mid-1; 
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

        boolean possible(int [] bloomDay,int d,int m,int k){
            int c=0,b=0,n=bloomDay.length;
            for(int i=0;i<n;i++){
               if(bloomDay[i]<=d){
                c++;
               }
               else{
                    b+=(c/k);
                    c=0;
               }
            }
            b+=(c/k);
            if(b>=m) return true;
            return false;
        }
}