class Solution {
    public int searchInsert(int[] arr, int target) {
        int n=arr.length;
        int l=0,r=n-1,ans=n;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                ans= mid;
                r=mid-1;
                
            }
            else{
                ans= mid+1;
                l=mid+1;
                
            }
        }
        return ans;
    }
}