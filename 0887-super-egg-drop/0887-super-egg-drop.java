class Solution {
    public int superEggDrop(int n, int k) {
        int dp[][]=new int[n+1][k+1];
        
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(n,k,dp);   
    }
    
    static int solve(int i,int j,int dp[][]){
        int min=Integer.MAX_VALUE;
        if(j==0 || j==1) return j;
        if(i==1) return j;
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int low=1,high=j;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int left=solve(i-1,mid-1,dp);
            int right=solve(i,j-mid,dp);
            
            int temp=1+Math.max(left,right);
            min=Math.min(min,temp);
            
            if(left<right){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        
        return dp[i][j]=min;
    }
}