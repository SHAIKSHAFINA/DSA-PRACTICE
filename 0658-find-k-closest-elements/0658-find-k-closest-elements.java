class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer>sc=new ArrayList<>();
        int l=0,r=n-1;

        while(r-l+1 > k){
            int st=Math.abs(arr[l]-x);
            int end=Math.abs(arr[r]-x);

            if(st > end){
                l++;
            }
            else{
                r--;
            }
        }

        for(int i=l;i<=r;i++){
            sc.add(arr[i]);
        }
        return sc;
    }
}