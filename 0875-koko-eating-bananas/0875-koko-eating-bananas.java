class Solution {
    public int minEatingSpeed(int[] arr, int k) {
        int n=arr.length;
        int max=arr[0];
        
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        
        int l=1,r=max;
        
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(solve(arr,mid)>k){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
        
        
    }
    
    long solve(int[] arr,int mid){
        long c=0;
        
        for(int i=0;i<arr.length;i++){
            c+=(arr[i] + mid-1)/mid;
        }
        
        return c;
    }
}