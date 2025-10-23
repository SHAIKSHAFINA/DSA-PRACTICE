class Solution {
    public int splitArray(int[] arr, int k) {
        int n=arr.length;

        if(k>n) return -1;

        int s=0,max=Integer.MIN_VALUE;

        for(int x:arr){
            s+=x;
            max=Math.max(max,x);
        }

        int l=max,r=s;

        while(l<=r){

            int mid=l+(r-l)/2;
            if(possible(arr,mid,k)==true){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    boolean possible(int arr[],int dist,int k){
        int n=arr.length;

        int sum=0,c=1;

        for(int i=0;i<n;i++){
            if(arr[i]+sum>dist){
                c++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }

            if(c>k) return false;
        }

        return true;
    }
}