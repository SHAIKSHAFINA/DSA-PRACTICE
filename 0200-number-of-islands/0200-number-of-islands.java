class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return c;
    }

    void dfs(char[][]grid,int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return;
        }

        if(grid[i][j]=='0') return;

        grid[i][j]='0';

        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};

        for(int k=0;k<4;k++){
            dfs(grid,i+dr[k],j+dc[k],n,m);
        }
    }
}