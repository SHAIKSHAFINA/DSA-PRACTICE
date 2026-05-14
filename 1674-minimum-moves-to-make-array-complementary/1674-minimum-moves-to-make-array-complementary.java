class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int diff[]=new int[2*limit+2];

        for(int i=0;i<n/2;i++){
            int a=nums[i];
            int b=nums[n-i-1];
            int min=Math.min(a,b)+1;
            int max=Math.max(a,b)+limit;

            diff[2]+=2;
            diff[2*limit+1]-=2;

            diff[min]+=-1;
            diff[max+1]-=-1;

            int sum=a+b;

            diff[sum]+=-1;
            diff[sum+1]-=-1;

        }

        int mini=Integer.MAX_VALUE;
        int curr=0;

        for(int sum=2;sum<=2*limit;sum++){
            curr+=diff[sum];
            mini=Math.min(mini,curr);
        }

        return mini;
    }
}