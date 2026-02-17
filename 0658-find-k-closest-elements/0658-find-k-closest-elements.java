class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer>sc=new ArrayList<>();
        int l=0,r=n-k;

        while(l<r){
            int mid=l+(r-l)/2;
            int st=x-arr[mid];
            int end=arr[mid+k]-x;

            if(st > end){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }

        for(int i=l;i<l+k;i++){
            sc.add(arr[i]);
        }
        return sc;
    }
}