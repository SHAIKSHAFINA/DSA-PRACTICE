class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long maxi=nums[0];

        long [] pre=new long[n];
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
            pre[i]=gcd(maxi,nums[i]);
        }

        Arrays.sort(pre);
        sort(pre,n);
        long sum=0;
        
        for(int i=0;i<n/2;i++){
            sum+=gcd(pre[i],pre[n-i-1]);
        }
        return sum;
    }

    long gcd(long n,long m){
        long d=0;
        while(m!=0){
            d=n%m;
            n=m;
            m=d;
        }

        return n;

    }
    void sort(long arr[],int n){
        for(int i=0;i<n/2;i++){
            long temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
}