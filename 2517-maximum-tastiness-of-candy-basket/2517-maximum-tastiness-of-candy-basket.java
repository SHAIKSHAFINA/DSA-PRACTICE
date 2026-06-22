class Solution {
    public int maximumTastiness(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        int l=0,r=stalls[n-1]-stalls[0];
        
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(stalls,k,mid)){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        
        return r;
        
    }
    
    boolean solve(int stalls[],int k,int cow){
        int c=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=cow){
                c++;
                last=stalls[i];
            }
        }
        
        if(c>=k) return true;
        
        return false;
    }
}