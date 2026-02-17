class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int n=arr.length;
       List<int[]>sc=new ArrayList<>();

       for(int i=0;i<n;i++){
            int dist=Math.abs(arr[i]-x);
            int val=arr[i];
            sc.add(new int[]{dist,val});
       } 

       Collections.sort(sc,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            else{
                return a[1]-b[1];
            }
       });

       List<Integer> mp=new ArrayList<>();

       for(int i=0;i<k;i++){
        mp.add(sc.get(i)[1]);
       }
       Collections.sort(mp);
       return mp;
    }
}