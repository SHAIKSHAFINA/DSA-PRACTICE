class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int l=0,r=n-1;

        while(l<=r){
            int ans=arr[l]+arr[r];
            if(ans==target){
                return new int[]{l+1,r+1};
            }
            else if(ans>target){
                r--;
            }
            else{
                l++;
            }
        }

        return new int[]{};
    }
}