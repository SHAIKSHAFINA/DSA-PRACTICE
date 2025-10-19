class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;

        int l=0,r=n;

        while(l<r){
            int mid=l+(r-l)/2;
            int x=arr[mid]-(mid+1);
            if(x>=k){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l+k;
    }
}