class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n+1];
        int a[]=new int[n];
        Arrays.sort(arr);
        
        int max=1;
        int last=0;
        
        Arrays.fill(dp,1);
        
        for(int i=0;i<n;i++){
            a[i]=i;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && 1+dp[j] > dp[i]){
                     dp[i]=1+dp[j];
                     a[i]=j;
                }
               
            }
           if(dp[i]> max){
               max=dp[i];
               last=i;
           }
        }
        
        ArrayList<Integer> sc=new ArrayList<>();
        sc.add(arr[last]);
        
        while(a[last]!=last){
            last=a[last];
            sc.add(arr[last]);
        }
        Collections.reverse(sc);
        return sc;
    }
}