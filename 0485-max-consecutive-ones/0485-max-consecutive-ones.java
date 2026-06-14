class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length;
        int l=0,r=0,max=Integer.MIN_VALUE;
        int c=0;

        while(r<n){
            if(arr[r]==0){
                c=0;
                l=r+1;
            }
            c=(r-l+1);
            max=Math.max(max,c);
            r++;
        }

        return max;
    }
}