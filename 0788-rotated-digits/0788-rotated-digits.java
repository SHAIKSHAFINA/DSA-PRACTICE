class Solution {
    public int rotatedDigits(int n) {
        int c=0;
        int dp[]=new int[n+1];
        dp[0]=0;

        if(n==0) return 0;

        for(int i=1;i<=n;i++){
            int remain=dp[i/10];

            if(remain==2){
                dp[i]=2;
                continue;
            }
            
            int digitCheck=0;
            int digit=i%10;

            if(digit==1 || digit==0 || digit==8){
                digitCheck=0;
            }
            else if(digit==2 || digit==5 || digit==6 || digit==9){
                digitCheck=1;
            }
            else{
                 dp[i]=2;
                 continue;
            }

            if(remain==0 && digitCheck==0){
                  dp[i]=0;
            }
            else{
                dp[i]=1;
            }

             if(dp[i]==1){
                c++;
             }
        }

        return c;
    }

}