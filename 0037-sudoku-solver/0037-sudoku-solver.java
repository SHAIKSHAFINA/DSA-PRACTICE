class Solution {
    public void solveSudoku(char[][] board) {
        boolean row[][] =new boolean[9][9];
        boolean col[][] =new boolean[9][9];
        boolean box[][] =new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int boxIndex = (r / 3) * 3 + (c / 3);

                    row[r][num] = true;
                    col[c][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }
        if(solve(board,0,0,row,col,box)) return;
}

    boolean solve(char[][]b,int i,int j,boolean row[][],boolean col[][],boolean box[][]){

        if(i==9){
            return true;
        }
        if(j==9){
            return solve(b,i+1,0,row,col,box);
        }

        if(b[i][j]!='.'){
            return solve(b,i,j+1,row,col,box);
        }
        else{
            for(char x='1';x<='9';x++){
                int boxIndex=(i/3)*3 + (j/3);
                int num=x-'1';
                if(!row[i][num] && !col[j][num] && !box[boxIndex][num]){
                    b[i][j]=x;
                    row[i][num]=true;
                    col[j][num]=true;
                    box[boxIndex][num]=true;

                    if(solve(b,i,j+1,row,col,box)) return true;
                    b[i][j]='.';

                    row[i][num]=false;
                    col[j][num]=false;
                    box[boxIndex][num]=false;
                }
            }
        }
        return false;
    }
}