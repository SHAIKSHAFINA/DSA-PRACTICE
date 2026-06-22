class Solution {
    public int maxPossibleScore(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        long l=0,r=(long)stalls[n-1]+k-stalls[0];
        
        while(l<=r){
            long mid=l+(r-l)/2;
            if(solve(stalls,k,mid)){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        
        return (int)r;
        
    }
    
    boolean solve(int stalls[],int k,long cow){
       long prev=stalls[0];

       for(int i=1;i<stalls.length;i++){
            long l=stalls[i];
            long r=l+k;
            long c=Math.max(l,prev+cow);

            if(c>r) return false;

            else{
                prev=c;
                continue;
            }
       }
        
        return true;
    }
}