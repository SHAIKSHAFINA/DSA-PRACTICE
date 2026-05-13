class Solution {
    public int minCut(String s) {
     int n=s.length();
        int dp[]=new int[n];
        
        Arrays.fill(dp,-1);
        
        boolean[][] palindrome=new boolean[n][n];
        isPalindrome(s,palindrome);
        return solve(s,0,dp,palindrome)-1;
        
    }
    
    static int solve(String s,int i,int dp[],boolean palindrome[][]){
        int n=s.length();
        int min=Integer.MAX_VALUE;
        int left=0,right=0;
        if(i==n){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        for(int k=i;k<n;k++){
            if (palindrome[i][k]) {

                int temp =1 + solve(s,k + 1,dp,palindrome);

                min = Math.min(min, temp);
            }
        }
        
        return dp[i]=min;
    }
    static void isPalindrome(String s,boolean[][] palindrome){
        int n=s.length();
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                
                if(gap==0){
                    palindrome[i][j]=true;
                }
                else if(gap==1){
                    palindrome[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else{
                    palindrome[i][j]=(s.charAt(i)==s.charAt(j)) && palindrome[i+1][j-1];
                }
            }
        }
    }
}