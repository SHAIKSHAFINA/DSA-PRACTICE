class Solution {
    public int longestStrChain(String[] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)-> a.length()-b.length());

        int dp[]=new int[n];
        dp[0]=1;
        int max=1;

        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(compare(arr[i],arr[j]) && 1+dp[j] > dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            max=Math.max(max,dp[i]);
        }

        return max;
    }

    boolean compare(String a, String b){
        int l=0,r=0,n=a.length(),m=b.length();
        if(n!=m+1) return false;

        while(l<n && r<m){
            if(a.charAt(l) == b.charAt(r)){
                l++;
                r++;
            }
            else{
                l++;
            }
        }

        if(m==r) return true;

        return false;

    }
}