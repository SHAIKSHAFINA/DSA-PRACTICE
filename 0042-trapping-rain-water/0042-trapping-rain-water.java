class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int lmax=arr[0];
        int rmax=arr[n-1];
        int max=0;
        int ans=0;

        if(n<3){
            return 0;
        }

        for(int i=1;i<n;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }

        for(int i=1;i<max;i++){
            if(arr[i]>lmax){
                lmax=arr[i];
            }
            ans+=(lmax-arr[i]);
        }

        for(int i=n-2;i>max;i--){
            if(arr[i]>rmax){
                rmax=arr[i];
            }
            ans+=(rmax-arr[i]);
        }

        return ans;
    }
}