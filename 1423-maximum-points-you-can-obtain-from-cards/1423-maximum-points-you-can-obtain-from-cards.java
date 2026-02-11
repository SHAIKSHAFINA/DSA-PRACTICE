class Solution {
    public int maxScore(int[] arr, int k) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int max=sum;

        for(int i=1;i<=k;i++){
            sum=sum-arr[k-i]+arr[n-i];
            max=Math.max(max,sum);
        }
        return max;
    }
}