class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int l=0,r=n-1,min=Integer.MAX_VALUE;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[l]<=arr[r]){
                return arr[l];
            }
            if(arr[mid+1] <arr[mid]){
                return arr[mid+1];
            }

            if(arr[mid]<arr[mid-1]){
                return arr[mid];
            }

            if(arr[r]>=arr[mid]){
                r=mid-1;
            }

            else{
                l=mid+1;
            }
        }
        return -1;
    }
}