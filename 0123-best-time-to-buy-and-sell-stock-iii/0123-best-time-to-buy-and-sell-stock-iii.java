class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int after[][]=new int[2][3];
        int curr[][]=new int[2][3];

       for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                after[j][0]=0;
            }
       }

       for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                after[i][j]=0;
            }
       }

       for(int i=n-1;i>=0;i--){
        for(int j=0;j<2;j++){
            for(int c=1;c<=2;c++){
                if(j==1){
                   curr[j][c]=Math.max(-prices[i]+after[0][c], after[1][c]);
                        
                }
                else{
                    curr[j][c]=Math.max(prices[i]+after[1][c-1], after[0][c]);
                }
                after=curr;
            }
        }

       }

        return after[1][2];

    }
}