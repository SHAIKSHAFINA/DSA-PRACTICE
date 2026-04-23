class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean ans=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                     ans=backtrack(board,word,i,j,0);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }

        return ans;
    }

    boolean backtrack(char[][]board,String word,int i,int j,int k){
        int n=board.length;
        int m=board[0].length;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]=='#'){
            return false;
        }
         if(board[i][j]!=word.charAt(k)){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }
        char original=board[i][j];
        
            board[i][j]='#';
           boolean found= backtrack(board,word,i+1,j,k+1) ||
            backtrack(board,word,i-1,j,k+1) ||
            backtrack(board,word,i,j+1,k+1) ||
            backtrack(board,word,i,j-1,k+1);
            board[i][j]=original;
            return found;
        
    }
}