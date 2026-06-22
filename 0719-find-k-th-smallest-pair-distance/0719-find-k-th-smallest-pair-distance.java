class Solution {
    public int smallestDistancePair(int[] stalls, int k) {
       int n=stalls.length;
        Arrays.sort(stalls);
        int l=0,r=stalls[n-1]-stalls[0];
        
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(stalls,k,mid)>=k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        
        return l;
        
    }
    
    int solve(int stalls[],int k,int cow){
        int c=0;
        int l=0;
        for(int r=1;r<stalls.length;r++){

            while(stalls[r]-stalls[l]>cow){
               l++;

            }
            c+=r-l;
        }
        
        return c;
    }
}