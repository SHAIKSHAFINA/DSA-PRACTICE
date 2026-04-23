class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }

    boolean solve(char[][] board, String word,int i,int j,int start){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;
        
        if(board[i][j]!=word.charAt(start)) return false;
        if(start==word.length()-1){
            return true;
        }
        
        char temp=board[i][j];
        board[i][j]='#';

        int[] row={1,-1,0,0};
        int[] col={0,0,1,-1};
       

        for(int k=0;k<4;k++){
            int newRow=i+row[k];
            int newCol=j+col[k];
                
                if(solve(board,word,newRow,newCol,start+1)){
                    board[i][j]=temp;
                    return true;
                
            }
        }
        board[i][j]=temp;
        return false;
    }
}