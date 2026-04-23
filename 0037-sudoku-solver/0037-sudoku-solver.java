class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(board,0,0)) return;;
    }

    boolean solve(char[][]b,int i,int j){
        if(i==9){
            return true;
        }
        if(j==9){
            return solve(b,i+1,0);
        }

        if(b[i][j]!='.'){
            return solve(b,i,j+1);
        }
        else{
            for(char x='1';x<='9';x++){
                if(isCheck(i,j,b,x)){
                    b[i][j]=x;
                    if(solve(b,i,j+1)) return true;
                    b[i][j]='.';
                }
            }
        }
        return false;
    }

    boolean isCheck(int i,int j,char[][]b,char x){
        //row
        for(int c=0;c<9;c++){
            if(b[i][c]==x){
                return false;
            }
        }

        //col

        for(int r=0;r<9;r++){
            if(b[r][j]==x){
                return false;
            }
        }

        int row=(i/3)*3;
        int col=(j/3)*3;

        //3*3
        for(int m=row;m<row+3;m++){
            for(int n=col;n<col+3;n++){
                if(b[m][n]==x){
                    return false;
                }
            }
        }

        return true;
    }
}