class Solution {
    public long repairCars(int[] arr, int k) {
        int n=arr.length;
        long min=arr[0];
        
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
        }
        
        long l=1,r=min*k*k;
        
        while(l<=r){
            long mid=l+(r-l)/2;
            
            if(solve(arr,mid,k)>=k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    
    long solve(int[] arr,long mid,int k){
        long c=0;
        
        for(int i=0;i<arr.length;i++){
            c+=Math.sqrt(mid/arr[i]);
        }
        return c;
    }
}