class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(board,0,0)) return;
    }

    boolean solve(char[][] b, int i,int j){
        if(i==9) return true;
        if(j==9) return solve(b,i+1,0);

        if(b[i][j]!='.'){
            return solve(b,i,j+1);
        }

        for(char d='1';d<='9';d++){
            if(isValid(b,i,j,d)){
                b[i][j]=d;
                if(solve(b,i,j+1)) return true;
                b[i][j]='.';
            }
        }
        return false;
    }

    boolean isValid(char[][]b,int r,int c,int d){
        for(int k=0;k<9;k++){
            if(b[r][k]==d) return false;
            if(b[k][c]==d) return false;

            int row=(r/3)*3 + k/3;
            int col=(c/3)*3 + k%3;

            if(b[row][col]==d) return false;
        }

        return true;
    }
}