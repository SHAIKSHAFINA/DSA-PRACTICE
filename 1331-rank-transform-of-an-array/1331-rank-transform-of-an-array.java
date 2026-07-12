class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        
        int x[]=arr.clone();
        Arrays.sort(x);
        
        HashMap<Integer,Integer> mp=new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            if(!mp.containsKey(x[i])){
                mp.put(x[i],rank++);
            }
            
        }
        int [] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=mp.get(arr[i]);
        }
        return a;
    }
}