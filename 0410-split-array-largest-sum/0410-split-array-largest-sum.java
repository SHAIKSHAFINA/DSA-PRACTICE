class Solution {
    public int splitArray(int[] arr, int k) {
         int n=arr.length;
        int max=arr[0];
        int sum=0;
        if(n<k) return -1;
        
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            sum+=arr[i];
        }
        
        int l=max,r=sum;
        
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(solve(arr,k,mid)>k){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
        
        
    }
    
    int solve(int[] arr,int k,int mid){
        int sum=0;
        int c=1;
        
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }
            else{
                c++;
                sum=arr[i];
            }
        }
        
        return c;
    }
}