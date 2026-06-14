class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int lmax=0,rmax=n-1,max=0,ans=0;

        for(int i=0;i<n;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }

        for(int i=0;i<max;i++){
            if(arr[i]>arr[lmax]){
                lmax=i;
            }
            ans+=arr[lmax]-arr[i];
        }

         for(int i=n-2;i>max;i--){
            if(arr[i]>arr[rmax]){
                rmax=i;
            }
            ans+=arr[rmax]-arr[i];
        }

        return ans;
    }
}