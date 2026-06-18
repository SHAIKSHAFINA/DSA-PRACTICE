class Solution {
    public List<List<String>> solveNQueens(int n) {
        char mat[][]=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<>();

        solve(n,mat,0,res);
        return res;
    }

    void solve(int n,char mat[][],int i,List<List<String>> res){
        if(i==n){
            List<String> sc=new ArrayList<>();
            for(int r=0;r<n;r++){
                sc.add(new String(mat[r]));
            }
            res.add(sc);
            return;
        }
        
        for(int j=0;j<n;j++){
            if(isSafe(mat,i,j)){
                   mat[i][j]='Q';
                   solve(n,mat,i+1,res);
                   mat[i][j]='.';
                }
        }
        return;
    }

    boolean isSafe(char mat[][],int i,int j){
        int n=mat.length;
        for(int r=0;r<i;r++){
            if(mat[r][j]=='Q') return false;
            for(int c=0;c<n;c++){
                 if(mat[r][c]=='Q' && Math.abs(r-i)==Math.abs(c-j) ) return false;
            }
           
           
        }
        return true;
    }
}