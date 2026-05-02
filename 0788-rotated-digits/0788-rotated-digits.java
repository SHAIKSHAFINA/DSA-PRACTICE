class Solution {
    public int rotatedDigits(int n) {
        int c=0;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);

        for(int i=1;i<=n;i++){
            if(solve(i,dp)==1){
                c++;
            }
        }

        return c;
    }

    int solve(int n,int dp[]){
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n==0){
            dp[n]=0;
        }
        int remain=solve(n/10,dp);
  
        if(remain==2){
            return dp[n]=2;
        }

        int digitCheck=0;
        int digit=n%10;

        if(digit==1 || digit==0 || digit==8){
            digitCheck=0;
        }
        else if(digit==2 || digit==5 || digit==6 || digit==9){
            digitCheck=1;
        }
        else{
           return dp[n]=2;
        }

         if(remain==0 && digitCheck==0){
           return dp[n]=0;
         }

        return dp[n]=1;
    }

}