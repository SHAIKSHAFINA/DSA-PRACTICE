class Solution {
    public int minimizedMaximum(int k, int[] arr) {
        int n=arr.length;
        int max=arr[0];
        
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        
        int l=1,r=max;
        
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(solve(arr,mid,k)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    
    boolean solve(int[] arr,int mid,int k){
        int c=0;
        
        for(int i=0;i<arr.length;i++){
            c+=Math.ceil((double)arr[i]/mid);
        }

        if(c>k) return false; 
        return true;
    }
}