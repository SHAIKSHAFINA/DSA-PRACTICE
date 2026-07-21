class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int l=0,r=0,sum=0,avg=0,c=0;

        while(r<n){
            sum+=arr[r];
            while((r-l+1)>k){
                sum-=arr[l];
                l++;
            }

            if((r-l+1)==k && (sum/k)>=threshold){
                c++;
            }
            r++;
        }

        return c;
    }
}