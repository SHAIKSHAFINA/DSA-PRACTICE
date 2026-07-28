class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int min=arr[0];
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                min= arr[i+1];
            }
        }
        return min;
    }
}